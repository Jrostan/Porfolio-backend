/*Entidad Habilidades Digitales*/
package com.porfolio.porfolio.yo.programo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class HabilidadesDigitales {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String tecnologia;
    @NotNull
    private int porcentaje;
    @NotNull
    private String colorBarraFuerte;
    @NotNull
    private String ColorBarraDebil;

    //constructores:
    
    public HabilidadesDigitales() {
    }

    public HabilidadesDigitales(String tecnologia, int porcentaje, String colorBarraFuerte, String ColorBarraDebil) {
        this.tecnologia = tecnologia;
        this.porcentaje = porcentaje;
        this.colorBarraFuerte = colorBarraFuerte;
        this.ColorBarraDebil = ColorBarraDebil;
    }
    
    //Getters and Setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return ColorBarraDebil;
    }

    public void setColorBarraDebil(String ColorBarraDebil) {
        this.ColorBarraDebil = ColorBarraDebil;
    }
    
    
    
}
