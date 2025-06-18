package com.sample.core.dao;

import java.util.List;
import com.sample.core.domain.Voto;
import com.sample.core.domain.VotoResumen;

public interface VotoDao {
    public Voto findById(int id) throws Exception;
    public List<Voto> list() throws Exception;
    public void save(int DNI, int id_candidato) throws Exception;
    public void delete(int id) throws Exception;
    void guardarVoto(int id_padron, int presidente, int vicepresidente, int gobernador, int id_mesa) throws Exception;

    List<VotoResumen> contarVotosPorPartido(String rol) throws Exception;
}