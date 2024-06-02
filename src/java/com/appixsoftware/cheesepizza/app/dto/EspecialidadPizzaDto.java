/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.dto;

import java.io.Serializable;

/**
 *
 * @author LUIS.MU
 */
public class EspecialidadPizzaDto implements Serializable{

    private String idEspecialidad;
    private String nombreEspecialidad;
    private String ingredientesEspecialidad;
    private String imgUrl;
    private String aplica2x1Especialidad;
    private String aplicaP1Especialidad;

    /**
     * @return the idEspecialidad
     */
    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad the idEspecialidad to set
     */
    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     * @return the nombreEspecialidad
     */
    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    /**
     * @param nombreEspecialidad the nombreEspecialidad to set
     */
    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    /**
     * @return the ingredientesEspecialidad
     */
    public String getIngredientesEspecialidad() {
        return ingredientesEspecialidad;
    }

    /**
     * @param ingredientesEspecialidad the ingredientesEspecialidad to set
     */
    public void setIngredientesEspecialidad(String ingredientesEspecialidad) {
        this.ingredientesEspecialidad = ingredientesEspecialidad;
    }

    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the aplica2x1Especialidad
     */
    public String getAplica2x1Especialidad() {
        return aplica2x1Especialidad;
    }

    /**
     * @param aplica2x1Especialidad the aplica2x1Especialidad to set
     */
    public void setAplica2x1Especialidad(String aplica2x1Especialidad) {
        this.aplica2x1Especialidad = aplica2x1Especialidad;
    }

    /**
     * @return the aplicaP1Especialidad
     */
    public String getAplicaP1Especialidad() {
        return aplicaP1Especialidad;
    }

    /**
     * @param aplicaP1Especialidad the aplicaP1Especialidad to set
     */
    public void setAplicaP1Especialidad(String aplicaP1Especialidad) {
        this.aplicaP1Especialidad = aplicaP1Especialidad;
    }
    
 
}
