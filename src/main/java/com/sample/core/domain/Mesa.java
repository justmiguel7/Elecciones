package com.sample.core.domain;

public class Mesa {

	private int id_mesa;
	private int mesa;
	private String distrito;
	private int id_padron;
	private int orden;

	public Mesa(int id_mesa) {

		this.id_mesa = id_mesa;

	}

	public int getId_mesa() {
		return id_mesa;
	}

	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}

	public Mesa(int id_mesa, int  mesa, String distrito, int id_padron, int orden ){

		this.id_mesa = id_mesa;
		this.mesa  = mesa;
		this.distrito = distrito;
		this.id_padron = id_padron;
		this.orden = orden;
	

	}

	
	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getId_padron() {
		return id_padron;
	}

	public void setId_padron(int id_padron) {
		this.id_padron = id_padron;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	
	
	
}

	
