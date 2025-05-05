package com.sample.core.service;

import com.sample.core.dao.LoginCiudadanoDao;
import com.sample.core.dao.LoginCiudadanoDao;
import com.sample.core.dao.LoginCiudadanoDaoImp;

public class LoginCiudadanoServiceImp implements LoginCiudadanoService {

	
	
	private LoginCiudadanoDao loginCiudadanoDao = new LoginCiudadanoDaoImp();
	
	

	@Override
	public void consultarDni(int DNI) throws Exception {
		loginCiudadanoDao.existeDNI(DNI);
		
	}



	@Override
	public void consultarLoginCiudadano(int DNI) throws Exception {
		// TODO Auto-generated method stub
		
	}

	




}
   