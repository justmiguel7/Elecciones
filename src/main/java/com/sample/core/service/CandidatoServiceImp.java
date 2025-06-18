package com.sample.core.service;

import java.util.List;

import com.sample.core.dao.CandidatoDao;
import com.sample.core.dao.CandidatoDaoImp;
import com.sample.core.domain.Candidato;

public class CandidatoServiceImp implements CandidatoService {

    private CandidatoDao candidatoDao = new CandidatoDaoImp();

    @Override
    public List<Candidato> listarCandidatos() throws Exception {
        return candidatoDao.list();
    }

    @Override
    public Candidato consultarCandidatos(int id) throws Exception {
        return candidatoDao.findById(id);
    }

    @Override
    public List<Candidato> listarImagenes() throws Exception {
        return candidatoDao.listarImagenes();
    }
}