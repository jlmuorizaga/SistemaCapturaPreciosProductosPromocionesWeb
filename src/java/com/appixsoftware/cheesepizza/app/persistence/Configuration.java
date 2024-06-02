/*
 * Sistema de Punto de Venta
 * Desarrollado para uso exclusivo de Cheese Pizza
 * Por Appix Software
 * Aguascalientes, México
 * (c) 2020
 */
package com.appixsoftware.cheesepizza.app.persistence;

import java.io.Serializable;

/**
 *
 * @author joseluis-mondragon
 */
public class Configuration implements Serializable {

    private String clave;
    private String nombreSucursal;

 
    @Override
    public String toString() {
        return "clave: " + clave + ", nombreSucursal: " + nombreSucursal;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the nombreSucursal
     */
    public String getNombreSucursal() {
        return nombreSucursal;
    }

    /**
     * @param nombreSucursal the nombreSucursal to set
     */
    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

}
