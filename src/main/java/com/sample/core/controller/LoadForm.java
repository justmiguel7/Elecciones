package com.sample.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns =  "/formulario")
public class LoadForm extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String PADRON_FORM ="padron/padronForm.jsp";

	private static String VER_VOTO_FORM ="votos/votoForm.jsp";

	private static String POSTRE_FORM ="postre/PostreForm.jsp";

	private static String MENU_FORM ="menu/menuForm.jsp";
	
	private static String LOG_IN = "administrador/login.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		if (req.getParameter("form").equals("padronform")) {
			req.getRequestDispatcher(PADRON_FORM).forward(req, resp);
		}else if(req.getParameter("form").equals("votosform")){
			req.getRequestDispatcher(VER_VOTO_FORM).forward(req, resp);
		}else if (req.getParameter("form").equals("postreForm")) {
			req.getRequestDispatcher(POSTRE_FORM).forward(req, resp);
		}else if(req.getParameter("form").equals("menuForm")) {
			req.getRequestDispatcher(MENU_FORM).forward(req, resp);
		}else if(req.getParameter("form").equals("login")) {
			req.getRequestDispatcher(LOG_IN).forward(req, resp);
		}else {
			req.getRequestDispatcher("").forward(req, resp);
		}
	}
	
}
