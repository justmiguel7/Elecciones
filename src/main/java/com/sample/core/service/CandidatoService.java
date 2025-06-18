	package com.sample.core.service;
	
	import java.util.List;
	import java.util.Map;
	
	import com.sample.core.domain.Candidato;
	
	public interface CandidatoService {
	
		public List<Candidato> listarCandidatos() throws Exception;
		
		   List<Candidato> listarImagenes() throws Exception;
		
		public Candidato consultarCandidatos(int id) throws Exception;
		
	}
