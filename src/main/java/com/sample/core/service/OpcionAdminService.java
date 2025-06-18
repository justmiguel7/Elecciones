package com.sample.core.service;

import java.util.List;
import com.sample.core.domain.OpcionAdmin;

public interface OpcionAdminService {
	
    List<OpcionAdmin> listarOpciones() throws Exception;
    
}