package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Plato;

public interface PlatoDao {

	
	public List<Plato> list() throws Exception;
	
	public Plato findById(int id) throws Exception;
	
	public void delete (int id) throws Exception;
	
	public void save (String titulo, String descripcion, int precio) throws Exception;
	
	
}
