/*Entidad del heather o de la persona*/
package com.porfolio.porfolio.yo.programo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class PersonaPrincipal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(length = 5000)
    private String descripcion;
    @NotNull
    private String urlFoto;
    @NotNull
    private String titulo;
    @NotNull
    private String oriundo;
    
    //Constructors:

    public PersonaPrincipal() {
    }

    public PersonaPrincipal(String nombre, String descripcion, String urlFoto, String titulo, String oriundo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
        this.titulo = titulo;
        this.oriundo = oriundo;
    }

    //Getters and Setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
