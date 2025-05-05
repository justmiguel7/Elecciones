package com.sample.core.dao;


public interface LoginDao {
	
	public void existeCorreo(String correo) throws Exception ;
	
	public void existeCorreoContrasena(String correo, String contrasena) throws Exception ;
	
	public void agregarReintento(String correo) throws Exception;

	
	
}
