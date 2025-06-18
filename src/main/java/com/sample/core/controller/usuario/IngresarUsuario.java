package com.sample.core.controller.usuario;

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
import com.sample.core.service.LoginService;
import com.sample.core.service.LoginServicelmp;

@WebServlet(urlPatterns = "/ingresarUsuario")
public class IngresarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService correoservice = new LoginServicelmp();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String correo = req.getParameter("usuario");
		String contrasena = req.getParameter("password");

		try {
			if (correo == null || correo.length() == 0)
				throw new Exception("Correo vacio");
			if (contrasena == null || contrasena.length() == 0)
				throw new Exception("Contraseña vacia");
			

			correoservice.consultarCorreo(correo);
			correoservice.consultarCorreoYContrasena(correo, contrasena);

			 // CERRAR SESIÓN DE CIUDADANO SI EXISTE
	        HttpSession sessionExistente = req.getSession(false);
	        if (sessionExistente != null && sessionExistente.getAttribute("CURRENT_CIUDADANO") != null) {
	            sessionExistente.invalidate();
	            Cookie cookie = new Cookie("JSESSIONCIUDADANOID", "");
	            cookie.setMaxAge(0);
	            cookie.setPath("/");
	            resp.addCookie(cookie);
	        }
			
			HttpSession session = req.getSession(true);
			session.setAttribute("CURRENT_USER", correo);
			resp.addCookie(new Cookie("JSESSIONID", session.getId()));

			setOutResponse("Se logeó correctamente", resp, 200, "ok");

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
