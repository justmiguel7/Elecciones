package com.sample.core.domain;

import java.time.LocalDateTime;

public class Voto {
     
	
	private int id_voto;
	private int DNI;
	private int id_candidato;
	private LocalDateTime fecha_Hora;

	public Voto(int id_usuario, int id_candidato) {

		this.DNI = id_usuario;
		this.id_candidato = id_candidato;

	}  	public Voto(int id_voto, int id_usuario, int id_candidato, LocalDateTime fecha_hora) {

		
		
		this.id_voto = id_voto;
		this.DNI= id_usuario;
		this.id_candidato = id_candidato;  
		this.fecha_Hora = fecha_hora;
		
	
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int id_usuario) {
		this.DNI= id_usuario;
	}

	public int getId_candidato() {
		return id_candidato;
	}

	public void setId_candidato(int id_candidato) {
		this.id_candidato = id_candidato;
	}



	public int getId_voto() {
		return id_voto;
	}



	public void setId_voto(int id_voto) {
		this.id_voto = id_voto;
	}



	public LocalDateTime getFecha_Hora() {
		return fecha_Hora;
	}



	public void setFecha_Hora(LocalDateTime fecha_Hora) {
		this.fecha_Hora = fecha_Hora;
	}

}


