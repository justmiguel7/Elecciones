	package com.sample.core.controller.votos;

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

import com.sample.core.service.VotoService;
import com.sample.core.service.VotoServiceImp;


@WebServlet("/LeerDatosVotos")

public class LeerDatosVotos extends HttpServlet {

	private VotoService votoService = new VotoServiceImp();
	
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
			request.setAttribute("votos", votoService.listarVoto());
			request.getRequestDispatcher("/votos/votosPage.jsp").forward(request, response);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
    }
        
    }
    
}
