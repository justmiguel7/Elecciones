package com.sample.core.controller.mesa;

import com.google.gson.Gson;
import com.sample.core.domain.Mesa;
import com.sample.core.service.MesaService;
import com.sample.core.service.MesaServiceImp;
import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet("/LeerDatosMesa")
public class LeerDatosMesa extends HttpServlet {

    private MesaService mesaService = new MesaServiceImp();
    private PadronService padronService = new PadronServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "No autorizado");
            return;
        }

        Integer dni = (Integer) session.getAttribute("CURRENT_CIUDADANO");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            boolean yaVoto = padronService.verificarSiYaVoto(dni);
            if (yaVoto) {
                // Devuelve un JSON indicando que ya votó
                String json = new Gson().toJson(Collections.singletonMap("yaVoto", true));
                response.getWriter().print(json);
                return;
            }

            List<Mesa> mesas = mesaService.listarMesaPorDni(dni);
            String json = new Gson().toJson(mesas);
            response.getWriter().print(json);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener mesas");
        }
    }
}