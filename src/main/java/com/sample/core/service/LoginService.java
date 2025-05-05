package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Usuario;

public interface LoginService {
			
	public void consultarCorreo(String correo) throws Exception;
	
	public void consultarCorreoYContrasena(String correo, String  contrasena) throws Exception;

	
	
}
