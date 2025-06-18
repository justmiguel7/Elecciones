package com.sample.core.dao;

import java.util.List;


import com.sample.core.domain.Mesa;
import com.sample.core.domain.Padron;

public interface MesaDao {


	public List<Mesa> listByDistrito(String distrito) throws Exception;

	public List<Mesa> list() throws Exception;
	

	    List<Mesa> listByDni(int dni) throws Exception;
	    
		public Mesa BuscarMesaPorDNI(int dni) throws Exception;

	

}
