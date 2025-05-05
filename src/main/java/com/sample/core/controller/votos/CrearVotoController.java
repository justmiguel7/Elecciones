package com.sample.core.controller.votos;


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
import com.sample.core.service.VotoService;
import com.sample.core.service.VotoServiceImp;


@WebServlet( urlPatterns =  "/CrearVoto")
public class CrearVotoController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	VotoService votoservice = new VotoServiceImp();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String DNIString = req.getParameter("DNI");
		String id_candidatoString = req.getParameter("candidato");
		
		
		int DNI = 0;
		int id_candidato =0;
		
		// Ver datos recibidos del formulario en pantalla de Eclipse

		DNI = Integer.parseInt(DNIString);
		id_candidato = Integer.parseInt(id_candidatoString);

		try {
		   votoservice.crearVoto(DNI,id_candidato);
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

