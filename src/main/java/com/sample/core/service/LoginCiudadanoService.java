package com.sample.core.service;

import java.util.List;
import com.sample.core.domain.LoginCiudadano;


public interface LoginCiudadanoService {
	
	public void consultarLoginCiudadano(int dni) throws Exception;
	
	public void consultarDni(int dni) throws Exception;

	
}
