package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Mesa;
import com.sample.core.domain.Mesa;



public interface MesaService {
	
	public List<Mesa> listarMesa() throws Exception;
	
	public void consultarMesa(int id_mesa) throws Exception;
	
	public List<Mesa> listarMesaPorDistrito(String distrito) throws Exception;

	
	    List<Mesa> listarMesaPorDni(int dni) throws Exception;
	



}
