package com.sample.core.service;

import java.util.List;

import com.sample.core.dao.LoginCiudadanoDao;
import com.sample.core.dao.LoginCiudadanoDao;
import com.sample.core.dao.LoginCiudadanoDaoImp;
import com.sample.core.domain.LoginCiudadano;

public class LoginCiudadanoServiceImp implements LoginCiudadanoService {

	
	
	private LoginCiudadanoDao loginCiudadanoDao = new LoginCiudadanoDaoImp();
	
	
	public List<LoginCiudadano> listarCiudadano() throws Exception {
		return loginCiudadanoDao.list();
	}

	@Override
	public void consultarDni(int DNI) throws Exception {
		loginCiudadanoDao.existeDNI(DNI);
		
	}


	@Override
	public void consultarLoginCiudadano(int DNI) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
   