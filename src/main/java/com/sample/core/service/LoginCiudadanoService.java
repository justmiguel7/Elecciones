package com.sample.core.service;

import java.util.List;
import com.sample.core.domain.LoginCiudadano;
import com.sample.core.domain.Padron;


public interface LoginCiudadanoService {
	
	public List<LoginCiudadano> listarCiudadano() throws Exception;
	
	public void consultarLoginCiudadano(int dni) throws Exception;
	
	public void consultarDni(int dni) throws Exception;

}
