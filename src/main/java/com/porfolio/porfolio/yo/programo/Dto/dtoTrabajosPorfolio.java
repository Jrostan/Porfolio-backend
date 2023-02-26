package com.porfolio.porfolio.yo.programo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoTrabajosPorfolio {

    @NotBlank
    private String proyecto;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String urlImagen;
    @NotBlank
    private String link;

    //Constructors
    public dtoTrabajosPorfolio() {
    }

    public dtoTrabajosPorfolio(String proyecto, String descripcion, String urlImagen, String link) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.link = link;
    }

    //getters & Setters
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
