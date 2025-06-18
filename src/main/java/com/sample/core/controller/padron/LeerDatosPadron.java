package com.sample.core.controller.padron;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;


@WebServlet("/LeerDatosPadron")

public class LeerDatosPadron extends HttpServlet {

	private PadronService padronService = new PadronServiceImp();
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("CURRENT_USER") == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "No autorizado");
            return;
        }
        else { 
    	
    	try {
			request.setAttribute("padrones", padronService.listarPadron());
			request.getRequestDispatcher("/padron/padronPage.jsp").forward(request, response);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
    }

}

}