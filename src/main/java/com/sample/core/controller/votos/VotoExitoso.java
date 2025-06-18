package com.sample.core.controller.votos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VotoExitoso")
public class VotoExitoso extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 	HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "No autorizado");
        return;
    }
    else { 
	
	try {
		request.getRequestDispatcher("/votoexitoso/votoexitoso.jsp").forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();	
	}
}
}


}
