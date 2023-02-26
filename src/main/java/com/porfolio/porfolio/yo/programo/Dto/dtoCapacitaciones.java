/*Capacitaciones DTO (Data Transfer Object)*/
package com.porfolio.porfolio.yo.programo.Dto;

import javax.validation.constraints.NotBlank;


public class dtoCapacitaciones {
    //se replican las mismas variables del Entity
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url_logo;
    @NotBlank
    private String formador;
    
    //cosntructors

    public dtoCapacitaciones() {
    }

    public dtoCapacitaciones(String titulo, String descripcion, String url_logo, String formador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_logo = url_logo;
        this.formador = formador;
    }
    
    //Getters and Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlLogo() {
        return url_logo;
    }

    public void setUrlLogo(String url_logo) {
        this.url_logo = url_logo;
    }

    public String getFormador() {
        return formador;
    }

    public void setFormador(String formador) {
        this.formador = formador;
    }
    
    
}
