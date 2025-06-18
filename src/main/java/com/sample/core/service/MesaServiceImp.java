package com.sample.core.service;

import java.util.List;


import com.sample.core.dao.MesaDao;
import com.sample.core.dao.MesaDao;
import com.sample.core.dao.MesaDaoImp;
import com.sample.core.domain.Mesa;


public class MesaServiceImp implements MesaService {

	
	
	private MesaDao mesaDao = new MesaDaoImp();
	
	
	public List<Mesa> listarMesa() throws Exception {
		return mesaDao.list();
	}

	public List<Mesa> listarMesaPorDistrito(String distrito) throws Exception {
	    return mesaDao.listByDistrito(distrito);
	}


	@Override
	public void consultarMesa(int id_mesa) throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	 @Override
	    public List<Mesa> listarMesaPorDni(int dni) throws Exception {
	        return mesaDao.listByDni(dni);
	    }

	@Override
	public Mesa buscarMesaPorDni(int dni) throws Exception {
		// TODO Auto-generated method stub
		return mesaDao.BuscarMesaPorDNI(dni);
	}	}
	 

   