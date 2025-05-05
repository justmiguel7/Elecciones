package com.sample.core.controller.plato;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Plato;
import com.sample.core.service.PlatoService;
import com.sample.core.service.PlatoServiceImpl;

@WebServlet( urlPatterns =  "/loadPlatoFormBaja")

public class LoadPlatoFormBaja extends HttpServlet{

		private PlatoService platoService = new PlatoServiceImpl();
		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/platoFormBaja.jsp");
			
			try {
				//req.setAttribute("platos", platoService.listarPlatos());
				 String id = req.getParameter("id");
				 System.err.println(id);
				 
				  Plato plato =  platoService.consultarPLato(Integer.parseInt(id));
				 
				 req.setAttribute("plato", plato);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ds.forward(req, resp);
			
	}
}
