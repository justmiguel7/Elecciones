package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.LoginCiudadano;

public interface LoginCiudadanoDao {

	public void existeDNI(int DNI) throws Exception;

	public void agregarReintento(int DNI) throws Exception;

	public List<LoginCiudadano> list() throws Exception;

}
