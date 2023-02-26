package com.porfolio.porfolio.yo.programo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersonaPrincipal {

    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String urlFoto;
    @NotBlank
    private String titulo;
    @NotBlank
    private String oriundo;
    

//costructors
    public dtoPersonaPrincipal() {
    }

    public dtoPersonaPrincipal(String nombre, String descripcion, String urlFoto, String titulo, String oriundo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.titulo = titulo;
        this.oriundo = oriundo;
    }

    
    
    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOriundo() {
        return oriundo;
    }

    public void setOriundo(String oriundo) {
        this.oriundo = oriundo;
    }
    
    

}
