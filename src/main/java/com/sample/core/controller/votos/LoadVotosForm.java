package com.sample.core.controller.votos;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Voto;

import com.sample.core.service.VotoService;
import com.sample.core.service.VotoServiceImp;


@WebServlet( urlPatterns =  "/loadVotoForm")


public class LoadVotosForm  extends HttpServlet{


	private VotoService votoService = new VotoServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/voto/votoForm.jsp");
		ds.forward(req, resp);
	
		try {
			//req.setAttribute("platos", platoService.listarPlatos());
			String id = req.getParameter("id_voto");
			 
			// System.err.println(id);
			 
			 Voto voto=  votoService.consultarVoto( Integer.parseInt(id) );
			 
			 req.setAttribute("voto", voto);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ds.forward(req, resp);
		
	}
	
}
