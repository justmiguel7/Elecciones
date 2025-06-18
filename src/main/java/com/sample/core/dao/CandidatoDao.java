package com.sample.core.dao;

import java.util.List;
import java.util.Map;

import com.sample.core.domain.Candidato;
import com.sample.core.exceptions.ErrorException;

public interface CandidatoDao {
    
    Candidato findById(int id) throws Exception;

    List<Candidato> list() throws Exception;
    
    List<Candidato> listarImagenes() throws Exception; 

}