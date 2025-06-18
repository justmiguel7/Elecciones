package com.sample.core.domain;

public class VotoResumen {
    private String partido;
    private int cantidad;

    public VotoResumen(String partido, int cantidad) {
        this.partido = partido;
        this.cantidad = cantidad;
    }

    public String getPartido() {
        return partido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}