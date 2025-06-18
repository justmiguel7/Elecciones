package com.sample.core.domain;

import java.time.LocalDateTime;

public class Voto {

    private int id_voto;
    private int DNI;
    private int id_presidente;
    private int id_vicepresidente;
    private int id_gobernador;
    private int id_mesa;
    private LocalDateTime fecha_Hora;
    

    public Voto(int DNI, int id_presidente, int id_vicepresidente, int id_gobernador, int id_mesa) {
        this.DNI = DNI;
        this.id_presidente = id_presidente;
        this.id_vicepresidente = id_vicepresidente;
        this.id_gobernador = id_gobernador;
        this.id_mesa = id_mesa;
    }

    public Voto(int id_voto, int DNI, int id_presidente, int id_vicepresidente, int id_gobernador, int id_mesa, LocalDateTime fecha_Hora) {
        this.id_voto = id_voto;
        this.DNI = DNI;
        this.id_presidente = id_presidente;
        this.id_vicepresidente = id_vicepresidente;
        this.id_gobernador = id_gobernador;
        this.id_mesa = id_mesa;
        this.fecha_Hora = fecha_Hora;
    }

    public int getId_voto() {
        return id_voto;
    }

    public void setId_voto(int id_voto) {
        this.id_voto = id_voto;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getId_presidente() {
        return id_presidente;
    }

    public void setId_presidente(int id_presidente) {
        this.id_presidente = id_presidente;
    }

    public int getId_vicepresidente() {
        return id_vicepresidente;
    }

    public void setId_vicepresidente(int id_vicepresidente) {
        this.id_vicepresidente = id_vicepresidente;
    }

    public int getId_gobernador() {
        return id_gobernador;
    }

    public void setId_gobernador(int id_gobernador) {
        this.id_gobernador = id_gobernador;
    }

    public LocalDateTime getFecha_Hora() {
        return fecha_Hora;
    }

    public void setFecha_Hora(LocalDateTime fecha_Hora) {
        this.fecha_Hora = fecha_Hora;
    }

	public int getId_mesa() {
		return id_mesa;
	}

	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}
    
}