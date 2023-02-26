package com.porfolio.porfolio.yo.programo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TrabajosPorfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String proyecto;
    @NotNull
    private String descripcion;
    @NotNull
    private String urlImagen;
    @NotNull
    private String link;

    //constructors 
    
    public TrabajosPorfolio() {
    }

    public TrabajosPorfolio(String proyecto, String descripcion, String urlImagen, String link) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.link = link;
    }

    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
