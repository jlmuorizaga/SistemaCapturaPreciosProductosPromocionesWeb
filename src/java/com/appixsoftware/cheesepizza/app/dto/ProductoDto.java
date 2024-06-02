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
public class ProductoDto implements Serializable{
    
    private String id;
    private String descripcion;
    private String tamanio;
    private String usaSalsa;
    private String idTipoProducto;
    private ProductoTipoDto productoTipo;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tamanio
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    /**
     * @return the usaSalsa
     */
    public String getUsaSalsa() {
        return usaSalsa;
    }

    /**
     * @param usaSalsa the usaSalsa to set
     */
    public void setUsaSalsa(String usaSalsa) {
        this.usaSalsa = usaSalsa;
    }

    /**
     * @return the idTipoProducto
     */
    public String getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(String idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    /**
     * @return the productoTipo
     */
    public ProductoTipoDto getProductoTipo() {
        return productoTipo;
    }

    /**
     * @param productoTipo the productoTipo to set
     */
    public void setProductoTipo(ProductoTipoDto productoTipo) {
        this.productoTipo = productoTipo;
    }

  }
