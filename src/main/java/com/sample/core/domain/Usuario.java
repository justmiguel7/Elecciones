package com.sample.core.domain;

public class Usuario extends GenericEntity{
	
	private String correo;
	private String contrasena;
	

	public Usuario(int id, String correo, String contrasena) {
		super.setId(id);
		this.correo = correo;
		this.contrasena = contrasena;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
