package com.sample.core.controller.votos;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.sample.core.dao.config.Conexion;
import com.sample.core.service.VotoService;
import com.sample.core.service.VotoServiceImp;

@WebServlet( urlPatterns =  "/VotosEliminar")
public class VotosEliminar extends HttpServlet {
	
	VotoService votoService = new VotoServiceImp();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
			
        if (id == null || id.trim().isEmpty()) {
            req.setAttribute("mensajeError", "Error: La descripción no puede estar vacía.");
            req.getRequestDispatcher("/loadVotoFormBaja").forward(req, resp);
            return;     
        }
        
        int idInt = Integer.parseInt(id);
        try {
		  votoService.delete(idInt);
			
		   PrintWriter out = resp.getWriter();
		   resp.setContentType("application/json");
		   resp.setCharacterEncoding("utf-8");
		   JsonObject obj = new JsonObject();
		   //resp.setStatus(200);
		   obj.addProperty("estatus","ok");
		   obj.addProperty("mensaje","Se elimino correctamente el voto");
		   out.print(obj.toString());
		   out.flush();	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}
}
