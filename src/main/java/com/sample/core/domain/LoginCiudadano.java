package com.sample.core.domain;

public class LoginCiudadano {

	private int DNI;
	private String nombre;
	private String apellido;
	private String sexo;
	private String nacionalidad;
	private String direccion;
	private int cp;
	private String localidad;
	private int telefono;

	public LoginCiudadano(int DNI) {

		this.DNI = DNI;

	}

	public int getDni() {
		return DNI;
	}

	public void setDni(int dni) {
		this.DNI = dni;
	}

	public LoginCiudadano(int DNI, String nombre, String apellido, String sexo, String nacionalidad, String direccion,
			int cp, String localidad, int telefono) {

		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.cp= cp;
		this.localidad = localidad;
		this.telefono = telefono;
		
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	
	
}
