package com.sample.core.service;

import java.util.List;
import com.sample.core.domain.Voto;
import com.sample.core.domain.VotoResumen;

public interface VotoService {
    public List<Voto> listarVoto() throws Exception;
    public Voto consultarVoto(int id) throws Exception;
    public void crearVoto(int DNI, int id_candidato ) throws Exception;
    public void delete(int id) throws Exception;
    public void guardarVoto(int id_padron, int presidente, int vicepresidente, int gobernador, int id_mesa) throws Exception;
    public List<VotoResumen> contarVotosPorPartido(String rol) throws Exception;
}