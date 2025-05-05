package com.sample.core.service;

import java.util.List;


import com.sample.core.domain.Padron;

public interface PadronService {


	public List<Padron> listarPadron() throws Exception;
	
	public Padron consultarPadron(int id) throws Exception;
	
	public void crearPadron(int DNI, String distrito, boolean ya_voto ) throws Exception;

	public void delete(int id) throws Exception;
	
	void modificarPadron(int id_padron, int DNI, String distrito, boolean ya_voto) throws Exception;

	
}
