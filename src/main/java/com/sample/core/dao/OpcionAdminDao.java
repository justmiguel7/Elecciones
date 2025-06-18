package com.sample.core.dao;

import java.util.List;
import com.sample.core.domain.OpcionAdmin;

public interface OpcionAdminDao {
    List<OpcionAdmin> listarOpciones() throws Exception;
}