/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author LUIS.MU
 */
public class RelacionPromocionEspecialSucursalDto implements Serializable {
    private String idPromocion;
    private PromocionEspecialDto promocion;
    private String idSucursal;
    private SucursalDto sucursal;
    private String activa;

    /**
     * @return the idPromocion
     */
    public String getIdPromocion() {
        return idPromocion;
    }

    /**
     * @param idPromocion the idPromocion to set
     */
    public void setIdPromocion(String idPromocion) {
        this.idPromocion = idPromocion;
    }

    /**
     * @return the promocion
     */
    public PromocionEspecialDto getPromocion() {
        return promocion;
    }

    /**
     * @param promocion the promocion to set
     */
    public void setPromocion(PromocionEspecialDto promocion) {
        this.promocion = promocion;
    }

    /**
     * @return the idSucursal
     */
    public String getIdSucursal() {
        return idSucursal;
    }

    /**
     * @param idSucursal the idSucursal to set
     */
    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    /**
     * @return the sucursal
     */
    public SucursalDto getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(SucursalDto sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the activa
     */
    public String getActiva() {
        return activa;
    }

    /**
     * @param activa the activa to set
     */
    public void setActiva(String activa) {
        this.activa = activa;
    }

    
    
}
