package com.sample.core.dao;

public interface LoginCiudadanoDao {

	public void existeDNI(int DNI) throws Exception;

	public void agregarReintento(int DNI) throws Exception;

}
