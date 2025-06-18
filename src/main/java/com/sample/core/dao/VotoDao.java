package com.sample.core.dao;

import java.util.List;




import com.sample.core.domain.Voto;

public interface VotosDao {
	
	public Voto findById(int id) throws Exception;
	
	public List<Voto> list() throws Exception;

	public void save( int DNI, int id_candidato) throws Exception;

	public void delete(int id) throws Exception;
	
	
	

}
 