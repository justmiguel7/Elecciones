package com.sample.core.service;

import java.util.List;

import com.sample.core.service.VotoService;
import com.sample.core.dao.VotosDao;
import com.sample.core.dao.VotosDaoImp;
import com.sample.core.domain.Voto;



public class VotoServiceImp implements VotoService {
	
	private VotosDao votoDao = new VotosDaoImp();
	
	
	public List<Voto> listarVoto() throws Exception {
		return votoDao.list();
	}

	public Voto consultarVoto(int id) throws Exception {
		return votoDao.findById(id);
	}

	public void crearVoto( int DNI, int id_candidato) throws Exception {
		votoDao.save(DNI, id_candidato);
	}
	
	public void delete(int id) throws Exception{
		votoDao.delete(id);
	}



}
