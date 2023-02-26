package com.porfolio.porfolio.yo.programo.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHabilidadesDigitales {

@NotBlank
private String tecnologia;
@NotBlank
private int porcentaje;
@NotBlank
private String colorBarraFuerte;
@NotBlank
private String colorBarraDebil;

//Constructors

    public dtoHabilidadesDigitales() {
    }

    public dtoHabilidadesDigitales(String tecnologia, int porcentaje, String colorBarraDebil, String colorBarraFuerte) {
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
        this.colorBarraDebil = colorBarraDebil;
        this.colorBarraFuerte = colorBarraFuerte;
    }

//Getters & Setters:

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getColorBarraFuerte() {
        return colorBarraFuerte;
    }

    public void setColorBarraFuerte(String colorBarraFuerte) {
        this.colorBarraFuerte = colorBarraFuerte;
    }

    public String getColorBarraDebil() {
        return colorBarraDebil;
    }

    public void setColorBarraDebil(String colorBarraDebil) {
        this.colorBarraDebil = colorBarraDebil;
    }
    
    

}
