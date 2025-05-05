package com.sample.core.domain;

public class Padron {
	
	private int id_padron;
	
	private int DNI;
	
	private String distrito;
	
	private boolean ya_voto;
	
	public Padron (int id_padron, String distrito) {
		this.id_padron = id_padron;
		this.distrito = distrito;
		
	}
	
	
	public Padron ( int id_padron, int DNI, String distrito, boolean ya_voto) {
		this.id_padron = id_padron;
		this.DNI = DNI;
		this.distrito = distrito;
		this.ya_voto = ya_voto;
	}

	public int getId_padron() {
		return id_padron;
	}

	public void setId_padron(int id_padron) {
		this.id_padron = id_padron;
	}
	


	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int dameIDPadron() {
		return this.getId_padron();
		
	}
	
	public String dameDistrito () {
		return this.getDistrito();
	}

	public int getDNI() {
		return DNI;
	}


	public void setDNI(int dNI) {
		DNI = dNI;
	}


	public boolean isYa_voto() {
		return ya_voto;
	}


	public void setYa_voto(boolean ya_voto) {
		this.ya_voto = ya_voto;
	}
	

	
	

}
