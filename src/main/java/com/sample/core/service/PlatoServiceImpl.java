package com.sample.core.service;

import java.util.List;

import com.sample.core.dao.PlatoDao;
import com.sample.core.dao.PlatoDaoImp;
import com.sample.core.domain.Plato;

public class PlatoServiceImpl implements PlatoService{

	private PlatoDao platoDao = new PlatoDaoImp();
	
	
	public List<Plato> listarPlatos() throws Exception {
		return platoDao.list();
	}

	public Plato consultarPLato(int id) throws Exception {
		return platoDao.findById(id);
	}

	public void crearPlato(String titulo, String descripcion, int precio) throws Exception {
		platoDao.save(titulo, descripcion, precio);
	}
	
	public void delete(int id) throws Exception{
		platoDao.delete(id);
	}

}
