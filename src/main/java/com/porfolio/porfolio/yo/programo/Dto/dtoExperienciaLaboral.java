
package com.porfolio.porfolio.yo.programo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperienciaLaboral {

@NotBlank
private String puesto;
@NotBlank
private String fechainicio;
@NotBlank
private String fechaFinal;
@NotBlank
private String descPuesto;
@NotBlank
private String empresa;
@NotBlank
private String urlLogo;

//Constructors

    public dtoExperienciaLaboral() {
    }

    public dtoExperienciaLaboral(String puesto, String fechainicio, String fechaFinal, String descPuesto, String empresa, String urlLogo) {
        this.puesto = puesto;
        this.fechainicio = fechainicio;
        this.fechaFinal = fechaFinal;
        this.descPuesto = descPuesto;
        this.empresa = empresa;
        this.urlLogo = urlLogo;
    }

//Getters & Setters

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
