package com.sample.core.controller.mesa;

import com.google.gson.Gson;
import com.sample.core.domain.Mesa;
import com.sample.core.service.MesaService;
import com.sample.core.service.MesaServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Mesa")
public class MesaController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute("CURRENT_CIUDADANO") == null) {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "No autorizado");
        return;
    }
    else {
    	
    	try {
			request.getRequestDispatcher(request.getContextPath() + "/mesa/mesaPage.jsp").forward(request, response);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
    	
    }

}

}