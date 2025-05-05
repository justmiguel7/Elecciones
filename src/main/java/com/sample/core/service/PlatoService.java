package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Plato;

public interface PlatoService {

	public List<Plato> listarPlatos() throws Exception;
	
	public Plato consultarPLato(int id) throws Exception;
	
	public void crearPlato(String titulo, String descripcion, int precio) throws Exception;

	public void delete(int id) throws Exception;
}
