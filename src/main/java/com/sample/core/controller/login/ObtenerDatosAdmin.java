package com.sample.core.controller.login;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.sample.core.domain.OpcionAdmin;
import com.sample.core.service.OpcionAdminService;
import com.sample.core.service.OpcionAdminServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/opciones-admin")
public class ObtenerDatosAdmin extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private OpcionAdminService service = new OpcionAdminServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        if (session == null || session.getAttribute("CURRENT_USER") == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.print("{\"mensaje\": \"No autorizado\"}");
            return;
        }

        try {
            List<OpcionAdmin> opciones = service.listarOpciones();
            String json = new Gson().toJson(opciones);
            out.print(json);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"mensaje\": \"Error interno\"}");
        }
    }
}
