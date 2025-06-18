package com.sample.core.controller.ciudadano;

import com.sample.core.domain.LoginCiudadano;
import com.sample.core.service.LoginCiudadanoService;
import com.sample.core.service.LoginCiudadanoServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import com.google.gson.Gson;

@WebServlet("/BuscarCiudadanoPorSesion")
public class BuscarCiudadanoPorSesion extends HttpServlet {

    private LoginCiudadanoService ciudadanoService = new LoginCiudadanoServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Setear tipo de respuesta
        response.setContentType("application/json;charset=UTF-8");

        HttpSession session = request.getSession(false); // false para no crear una nueva si no existe
        if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            response.getWriter().write("{\"error\":\"No hay sesión activa o DNI no encontrado\"}");
            return;
        }

        Integer DNI = (Integer) session.getAttribute("CURRENT_CIUDADANO");

        
        try {
        	Thread.sleep(500); // pausa 500ms en el server

            LoginCiudadano ciudadano = ciudadanoService.buscarPorDni(DNI);

            // Convertir a JSON
            Gson gson = new Gson();
            String json = gson.toJson(ciudadano);
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Error al obtener datos del ciudadano\"}");
        }
    }
}
