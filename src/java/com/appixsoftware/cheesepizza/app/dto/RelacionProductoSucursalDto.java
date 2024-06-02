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
public class RelacionProductoSucursalDto implements Serializable {
    private String idProducto;
    private ProductoDto producto;
    private String idSucursal;
    private SucursalDto sucursal;
    private BigDecimal precioNormal;
    private String aplicaBebidaChicaGratis;

    /**
     * @return the idProducto
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the producto
     */
    public ProductoDto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductoDto producto) {
        this.producto = producto;
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
     * @return the precioNormal
     */
    public BigDecimal getPrecioNormal() {
        return precioNormal;
    }

    /**
     * @param precioNormal the precioNormal to set
     */
    public void setPrecioNormal(BigDecimal precioNormal) {
        this.precioNormal = precioNormal;
    }

    /**
     * @return the aplicaBebidaChicaGratis
     */
    public String getAplicaBebidaChicaGratis() {
        return aplicaBebidaChicaGratis;
    }

    /**
     * @param aplicaBebidaChicaGratis the aplicaBebidaChicaGratis to set
     */
    public void setAplicaBebidaChicaGratis(String aplicaBebidaChicaGratis) {
        this.aplicaBebidaChicaGratis = aplicaBebidaChicaGratis;
    }
    
    
}
