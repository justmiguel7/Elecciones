package com.sample.core.service;

import java.util.List;
 
import com.sample.core.dao.PadronDao;
import com.sample.core.dao.PadronDaoImp;
import com.sample.core.domain.Padron;

public class PadronServiceImp implements PadronService {
	
	private PadronDao padronDao = new PadronDaoImp();
	
	
	public List<Padron> listarPadron() throws Exception {
		return padronDao.list();
	}

	public Padron consultarPadron(int id) throws Exception {
		return padronDao.findById(id);
	}

	public void crearPadron( int DNI, String distrito, boolean ya_voto) throws Exception {
		padronDao.save(DNI, distrito, ya_voto);
	}
	
	public void delete(int id) throws Exception{
		padronDao.delete(id);
	}

	public void modificarPadron(int id_padron, int DNI, String distrito, boolean ya_voto) throws Exception {
	    padronDao.update(id_padron, DNI, distrito, ya_voto);
	}

}
