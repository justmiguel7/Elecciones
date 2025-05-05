package com.sample.core.domain;

import java.util.List;

public class Pedido {

	private List<Pedible> pedibles;
	
	private int idMesa;
	
	
	public List<Pedible> getPedibles() {
		return pedibles;
	}

	public void setPedibles(List<Pedible> pedibles) {
		this.pedibles = pedibles;
	}
	
	public int getTotal() {
		return 0;
	}
	
	public String getTicket() {
		return null;
	}

	public int getIdMesa() {
		return idMesa;
	}

	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
}
