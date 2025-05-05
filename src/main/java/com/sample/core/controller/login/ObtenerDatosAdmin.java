package com.sample.core.controller.login;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/obtenerDatosAdmin")
public class ObtenerDatosAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;
	  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("CURRENT_USER") != null) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            
            out.println("<div class='card m-2'>");
            out.println("<img class='card-img-top' src='https://fotos.perfil.com/2019/05/22/trim/987/555/elecciones-urna-voto-g20180522-707903.jpg' alt='Card image cap'>");
            out.println("<div class='card-body'>");
            out.println("<h5 class='card-title'>Ver votos</h5>");
            out.println("<p class='card-text'>Ver los votos</p>");
            out.println("<a href='" + req.getContextPath() + "/LeerDatosVotos' class='btn btn-primary'>Ir</a>");
            out.println("</div></div>");

            out.println("<div class='card m-2'>");
            out.println("<img class='card-img-top'  src='https://media.istockphoto.com/id/1371167422/es/vector/concepto-de-contrataci%C3%B3n-de-personal.jpg?s=612x612&w=0&k=20&c=HjNMxrX9fakc9AVi9X3Z6ok-T3tGLaU85YNMhfJxtb8=' alt='Card image cap'>");
            out.println("<div class='card-body'>");
            out.println("<h5 class='card-title'>Candidatos</h5>");
            out.println("<p class='card-text'>Agregar y eliminar candidatos</p>");
            out.println("<a href='" + req.getContextPath() + "/LeerDatosBebidas' class='btn btn-primary'>Ir</a>");
            out.println("</div></div>");

            out.println("<div class='card m-2'>");
            out.println("<img class='card-img-top' src='https://conocimiento.blob.core.windows.net/conocimiento/2022/Contables/ContabilidadBancos/CasosPracticos/CP_Usuarios_y_perfiles/drex_usuarios_y_perfiles_custom.png' alt='Card image cap'>");
            out.println("<div class='card-body'>");
            out.println("<h5 class='card-title'>Ciudadanos</h5>");
            out.println("<p class='card-text'>Ver ciudadanos</p>");
            out.println("<a href='" + req.getContextPath() + "/LeerDatosCiudadano' class='btn btn-primary'>Ir</a>");
            out.println("</div></div>");

            out.println("<div class='card m-2'>");
            out.println("<img class='card-img-top' src='https://cloudfront-us-east-1.images.arcpublishing.com/infobae/PA5VI6NG75FA3MW5G4GSNWCY6Y.jpg' alt='Card image cap'>");
            out.println("<div class='card-body'>");
            out.println("<h5 class='card-title'>Editar Padron</h5>");
            out.println("<p class='card-text'>Agregar, eliminar y editar padrones</p>");
            out.println("<a href='" + req.getContextPath() + "/LeerDatosPadron' class='btn btn-primary'>Ir</a>");
            out.println("</div></div>");
        } 
    }
}
