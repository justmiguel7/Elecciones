package com.sample.core.controller.plato;

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
import com.sample.core.service.PlatoService;
import com.sample.core.service.PlatoServiceImpl;

@WebServlet( urlPatterns =  "/CrearPlato")
public class CrearPlatoController extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PlatoService platoservice = new PlatoServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String descripcion = req.getParameter("descripcion");
		String precioString = req.getParameter("precio");
		
		int precioInt = 0;
		
		// Ver datos recibidos del formulario en pantalla de Eclipse
		
		precioInt = Integer.parseInt(precioString);
		
		try {
		   platoservice.crearPlato(titulo,descripcion, precioInt);
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
