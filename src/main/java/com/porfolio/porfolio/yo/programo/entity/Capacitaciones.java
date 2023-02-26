/*Entidad Capacitaciones*/
package com.porfolio.porfolio.yo.programo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Capacitaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String titulo;
    @NotNull
    private String descripcion;
    @NotNull
    private String url_logo;
    @NotNull
    private String formador;
    
    //constructors:

    public Capacitaciones() {
    }

    public Capacitaciones(String titulo, String descripcion, String url_logo, String formador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_logo = url_logo;
        this.formador = formador;
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
