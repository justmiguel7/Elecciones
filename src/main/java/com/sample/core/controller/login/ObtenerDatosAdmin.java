package com.sample.core.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/obtenerDatosAdmin")
public class ObtenerDatosAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        if (session == null || session.getAttribute("CURRENT_USER") == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuario no autenticado");
            return;
        }

        PrintWriter out = resp.getWriter();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gobierno", "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT titulo, descripcion, imagen_url, enlace_url FROM opciones_admin")) {

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String imagen = rs.getString("imagen_url");
                String enlace = req.getContextPath() + rs.getString("enlace_url");

                out.println("<div class='card m-2'>");
                out.println("<img class='card-img-top' src='" + imagen + "' alt='Card image cap'>");
                out.println("<div class='card-body'>");
                out.println("<h5 class='card-title'>" + titulo + "</h5>");
                out.println("<p class='card-text'>" + descripcion + "</p>");
                out.println("<a href='" + enlace + "' class='btn btn-primary'>Ir</a>");
                out.println("</div></div>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error al cargar los datos.</p>");
        }
    }
}