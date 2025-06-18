package com.sample.core.domain;

import com.sample.core.enums.RolEnum;

public class Candidato {
     
    private int id_candidato;
    private int DNI;
    private String nombre_candidato;
    private String apellido_candidato;
    private String sexo_candidato;
    private String partido;
    private RolEnum rolEnum;
    private String imagen_candidato; 

    public Candidato(int id_candidato, int DNI, String nombre_candidato, String apellido_candidato, String sexo_candidato, String partido, RolEnum rolEnum, String imagen_candidato) {
        this.id_candidato = id_candidato;
        this.DNI = DNI;
        this.nombre_candidato = nombre_candidato;
        this.apellido_candidato = apellido_candidato;
        this.sexo_candidato = sexo_candidato;
        this.partido = partido;
        this.rolEnum = rolEnum;
        this.imagen_candidato = imagen_candidato;
    }


	public int getId_candidato() {
		return id_candidato;
	}



	public void setId_candidato(int id_candidato) {
		this.id_candidato = id_candidato;
	}



	public int getDNI() {
		return DNI;
	}



	public void setDNI(int dNI) {
		DNI = dNI;
	}



	public String getNombre_candidato() {
		return nombre_candidato;
	}



	public void setNombre_candidato(String nombre_candidato) {
		this.nombre_candidato = nombre_candidato;
	}



	public String getApellido_candidato() {
		return apellido_candidato;
	}



	public void setApellido_candidato(String apellido_candidato) {
		this.apellido_candidato = apellido_candidato;
	}



	public String getSexo_candidato() {
		return sexo_candidato;
	}



	public void setSexo_candidato(String sexo_candidato) {
		this.sexo_candidato = sexo_candidato;
	}



	public String getPartido() {
		return partido;
	}



	public void setPartido(String partido) {
		this.partido = partido;
	}

	public RolEnum getRolEnum() {
	    return rolEnum;
	}
	
	public void setRolEnum(RolEnum rolEnum) {
	    this.rolEnum = rolEnum;
	}



	public void setImagen_candidato(String imagen_candidato) {
		this.imagen_candidato = imagen_candidato;
	}
	
	  public String getImagen_candidato() {
	        return imagen_candidato;
	    }

	   	

}


	
