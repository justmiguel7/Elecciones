package com.sample.core.controller.padron;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.sample.core.dao.config.Conexion;
import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;
import com.sample.core.dao.PadronDaoImp;
import java.io.IOException;
import com.google.gson.JsonObject;


@WebServlet( urlPatterns =  "/CrearPadron")
public class CrearPadronController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	PadronService padronservice = new PadronServiceImp();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    String id_padronString = req.getParameter("id_padron");
		String DNIString = req.getParameter("DNI");
		String distrito = req.getParameter("distrito");
		String ya_votoString = req.getParameter("ya_voto");
		
		int DNI = 0;
		
		// Ver datos recibidos del formulario en pantalla de Eclipse

		DNI = Integer.parseInt(DNIString);
		boolean ya_voto = Boolean.parseBoolean(ya_votoString);

		try {
			
			if (id_padronString != null && !id_padronString.isEmpty()) {
	            int id_padron = Integer.parseInt(id_padronString);
	            padronservice.modificarPadron(id_padron, DNI, distrito, ya_voto); 
	        } else {
	            padronservice.crearPadron(DNI, distrito, ya_voto); 
	        }
			
		   PrintWriter out = resp.getWriter();
		   resp.setContentType("application/json");
		   resp.setCharacterEncoding("utf-8");
		   JsonObject obj = new JsonObject();
		   //resp.setStatus(200);
		   obj.addProperty("estatus","ok");
		   obj.addProperty("mensaje","Se creo exitosamente el registro");
		   out.print(obj.toString());
		   out.flush();	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
