package com.sample.core.domain;

public class OpcionAdmin {
    private int id;
    private String titulo;
    private String descripcion;
    private String imagen_url;
    private String enlace_url;

    public OpcionAdmin() {}

    public OpcionAdmin(int id, String titulo, String descripcion, String imagen_url, String enlace_url) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen_url = imagen_url;
        this.enlace_url = enlace_url;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public String getEnlace_url() {
        return enlace_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public void setEnlace_url(String enlace_url) {
        this.enlace_url = enlace_url;
    }
}
