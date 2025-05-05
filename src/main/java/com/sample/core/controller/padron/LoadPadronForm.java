package com.sample.core.controller.padron;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Padron;

import com.sample.core.service.PadronService;
import com.sample.core.service.PadronServiceImp;


@WebServlet( urlPatterns =  "/loadPadronForm")


public class LoadPadronForm  extends HttpServlet{


	private PadronService padronService = new PadronServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		try {
			
			String id = req.getParameter("id_padron");
			
			 if (id != null && !id.isEmpty()) {
		            int idPadron = Integer.parseInt(id);
		            Padron padron = padronService.consultarPadron(idPadron);
		            req.setAttribute("padron", padron);
		        } else {
		            System.err.println("⚠️ El parámetro 'id_padron' no está presente.");
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		        req.setAttribute("error", "Error al cargar el formulario del padrón.");
		    }
		RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/padron/padronForm.jsp");
		ds.forward(req, resp);
		
	}
	
}
