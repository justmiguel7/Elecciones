package com.sample.core.controller.padron;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Padron;
import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;


@WebServlet( urlPatterns =  "/loadPadronFormBaja")
public class PadronEliminarBaja extends HttpServlet {
	
	private PadronService padronService = new PadronServiceImp();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/padronFormBaja.jsp");
		
		try {
			//req.setAttribute("platos", platoService.listarPlatos());
			 String id = req.getParameter("id");
			 System.err.println(id);
			 
			  Padron padron =  padronService.consultarPadron(Integer.parseInt(id));
			 
			 req.setAttribute("padron", padron);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ds.forward(req, resp);
		
}
}
