package com.sample.core.controller.padron;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Padron")
public class PadronController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
		request.getRequestDispatcher(request.getContextPath() + "/ciudadano/loginciudadano.jsp").forward(request, response);
        return;
    }
    else {
    	
    	try {
			request.getRequestDispatcher(request.getContextPath() + "/Mesa").forward(request, response);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
    	
    }

}

}
