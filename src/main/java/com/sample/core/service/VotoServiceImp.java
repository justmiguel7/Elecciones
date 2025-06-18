package com.sample.core.service;

import java.util.List;

import com.sample.core.service.VotoService;
import com.sample.core.dao.VotoDao;
import com.sample.core.dao.VotosDaoImp;
import com.sample.core.domain.Voto;
import com.sample.core.domain.VotoResumen;



public class VotoServiceImp implements VotoService {
	
	private VotoDao votoDao = new VotosDaoImp();
	
	
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
	
	@Override
	public void guardarVoto(int id_padron, int presidente, int vicepresidente, int gobernador, int id_mesa) throws Exception {
	    votoDao.guardarVoto(id_padron, presidente, vicepresidente, gobernador, id_mesa);
	}

	@Override
	public List<VotoResumen> contarVotosPorPartido(String rol) throws Exception {
	    return votoDao.contarVotosPorPartido(rol);
	}

	

}
