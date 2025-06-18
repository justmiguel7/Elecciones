	package com.sample.core.controller.candidatos;

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

import com.sample.core.service.CandidatoService;
import com.sample.core.service.CandidatoServiceImp;


@WebServlet("/LeerDatosCandidatos")

public class LeerDatosCandidatos extends HttpServlet {

	private CandidatoService candidatoService = new CandidatoServiceImp();
	
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
			request.setAttribute("candidatos", candidatoService.listarCandidatos());
			request.getRequestDispatcher("/candidato/candidatoPage.jsp").forward(request, response);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
    }
}
    
}
