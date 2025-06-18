package com.sample.core.controller.ciudadano;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.sample.core.service.LoginCiudadanoService;
import com.sample.core.service.LoginCiudadanoServiceImp;

@WebServlet(urlPatterns = "/IngresarCiudadano")
public class IngresarCiudadano extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private LoginCiudadanoService ciudadanoService = new LoginCiudadanoServiceImp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 
	    String dniStr = req.getParameter("DNI");
	    int DNI;
	    
	    System.out.println(dniStr);
	    
		try {
			if (dniStr == null || dniStr.trim().isEmpty()) {
				throw new Exception("DNI vacio");
			}
			
			
		
	        DNI = Integer.parseInt(dniStr); 
	        
	        ciudadanoService.consultarDni(DNI);
	        
	     // CERRAR SESIÓN DE ADMINISTRADOR SI EXISTE
	        HttpSession session = req.getSession(false);
	        if (session != null && session.getAttribute("CURRENT_USER") != null) {
	            session.invalidate();
	            Cookie cookie = new Cookie("JSESSIONID", "");
	            cookie.setMaxAge(0);
	            cookie.setPath("/");
	            resp.addCookie(cookie);
	        }

			HttpSession sessionciudadano = req.getSession(true);
			sessionciudadano.setAttribute("CURRENT_CIUDADANO", DNI);
			resp.addCookie(new Cookie("JSESSIONCIUDADANOID", sessionciudadano.getId()));
			
			
			  JsonObject obj = new JsonObject();
			  resp.setContentType("application/json");
			  resp.setCharacterEncoding("utf-8");
			  resp.setStatus(200);
			  obj.addProperty("estatus", "ok");
			  obj.addProperty("mensaje", "Se logeó correctamente");
			  obj.addProperty("redirect", req.getContextPath() + "/Padron");
			    
			    PrintWriter out = resp.getWriter();
			    out.print(obj.toString());
			    out.flush();

		} catch (Exception e) {
			setOutResponse(e.getMessage(), resp, 400, "error");
		}
	}

	private void setOutResponse(String mensaje, HttpServletResponse resp, int code, String status) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		JsonObject obj = new JsonObject();
		resp.setStatus(code);
		obj.addProperty("estatus", status);
		obj.addProperty("mensaje", mensaje);
		out.print(obj.toString());
		out.flush();
	}
}
