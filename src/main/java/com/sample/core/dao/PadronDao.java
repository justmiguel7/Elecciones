package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Padron;

public interface PadronDao {
	
	public Padron findById(int id) throws Exception;
	
	public List<Padron> list() throws Exception;

	public void save( int DNI, String distrito, boolean ya_voto) throws Exception;

	public void delete(int id) throws Exception;

    void update(int id_padron, int DNI, String distrito, boolean ya_voto) throws Exception;

    public void marcarComoYaVoto(int dni) throws Exception;

    boolean verificarSiYaVoto(int dni) throws Exception; 

	public Padron buscarPadronPorDni(int dni) throws Exception;
	
	

}
