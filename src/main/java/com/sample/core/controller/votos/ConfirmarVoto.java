package com.sample.core.controller.votos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sample.core.service.VotoService;
import com.sample.core.service.VotoServiceImp;
import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;

@WebServlet("/confirmarVoto")
public class ConfirmarVoto extends HttpServlet {

    private VotoService votoService = new VotoServiceImp();
    private PadronService padronService = new PadronServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false); // No crear sesión si no existe
        PrintWriter out = resp.getWriter();

        if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado: sesión inexistente o no iniciada.");
            return;
        }

        Integer dni = (Integer) session.getAttribute("CURRENT_CIUDADANO");
        System.out.println("DNI de sesión: " + dni);

        try {
            boolean yaVoto = padronService.verificarSiYaVoto(dni);

            if (yaVoto) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN, "El ciudadano ya votó.");
                return;
            }

            // Leer JSON del body
            BufferedReader reader = req.getReader();
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(reader, JsonObject.class);

            int idPresidente = json.get("presidente").getAsInt();
            int idVicepresidente = json.get("vicepresidente").getAsInt();
            int idGobernador = json.get("gobernador").getAsInt();
            int idMesa = json.get("mesa").getAsInt(); // 

            // Guardar el voto
            votoService.guardarVoto(dni, idPresidente, idVicepresidente, idGobernador, idMesa);
            padronService.marcarComoYaVoto(dni);

            // Respuesta OK
            JsonObject response = new JsonObject();
            response.addProperty("estatus", "ok");
            response.addProperty("mensaje", "Voto registrado exitosamente.");
            response.addProperty("redirect", req.getContextPath() + "/VotoExitoso"); // Redirección opcional

            out.print(response.toString());
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            JsonObject error = new JsonObject();
            error.addProperty("estatus", "error");
            error.addProperty("mensaje", "Error al registrar el voto.");
            out.print(error.toString());
            out.flush();
        }
    }
}
