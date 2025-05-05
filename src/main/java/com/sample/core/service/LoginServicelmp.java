package com.sample.core.service;

import com.sample.core.dao.LoginDao;

import com.sample.core.dao.LoginDaolmp;

public class LoginServicelmp implements LoginService{

	private LoginDao loginDao = new LoginDaolmp();
	
	

	@Override
	public void consultarCorreo(String correo) throws Exception {
		loginDao.existeCorreo(correo);
		
	}


	@Override
	public void consultarCorreoYContrasena(String correo, String contrasena) throws Exception {
		loginDao.existeCorreoContrasena(correo, contrasena);
		
	}

	




}
