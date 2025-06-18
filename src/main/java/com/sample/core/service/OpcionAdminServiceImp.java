package com.sample.core.service;

import java.util.List;
import com.sample.core.dao.OpcionAdminDao;
import com.sample.core.dao.OpcionAdminDaoImpl;
import com.sample.core.domain.OpcionAdmin;

public class OpcionAdminServiceImp implements OpcionAdminService {

    private OpcionAdminDao dao = new OpcionAdminDaoImpl();

    @Override
    public List<OpcionAdmin> listarOpciones() throws Exception {
        return dao.listarOpciones();
    }
}