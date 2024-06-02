/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.dto;

import java.io.Serializable;

/**
 *
 * @author jlmuo
 */
public class RelacionSalsaSucursalDto implements Serializable {
    private String idSalsa;    
    private SalsaDto salsa;
    private String idSucursal;
    private SucursalDto sucursal;

    /**
     * @return the idSalsa
     */
    public String getIdSalsa() {
        return idSalsa;
    }

    /**
     * @param idSalsa the idSalsa to set
     */
    public void setIdSalsa(String idSalsa) {
        this.idSalsa = idSalsa;
    }

    /**
     * @return the salsa
     */
    public SalsaDto getSalsa() {
        return salsa;
    }

    /**
     * @param salsa the salsa to set
     */
    public void setSalsa(SalsaDto salsa) {
        this.salsa = salsa;
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
  
}
