/*Entidada Experiencia Laboral*/
package com.porfolio.porfolio.yo.programo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ExperienciaLaboral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String puesto;
    @NotNull
    private String fechainicio;
    @NotNull
    private String fechaFinal;
    @NotNull
    @Column(length = 5000)
    private String descPuesto;
    @NotNull
    private String empresa;
    @NotNull
    private String urlLogo;
    
    // constructores

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String puesto, String fechainicio, String fechaFinal, String descPuesto, String empresa, String urlLogo) {
        this.puesto = puesto;
        this.fechainicio = fechainicio;
        this.fechaFinal = fechaFinal;
        this.descPuesto = descPuesto;
        this.empresa = empresa;
        this.urlLogo = urlLogo;
    }
    
    // Getters and Setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDescPuesto() {
        return descPuesto;
    }

    public void setDescPuesto(String descPuesto) {
        this.descPuesto = descPuesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }
    
    
    
}
