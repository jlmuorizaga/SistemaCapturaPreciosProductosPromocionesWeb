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
public class RelacionEspecialidadTamanioPrecioSucursalDto implements Serializable{
    private String idEspecialidad;
    private EspecialidadPizzaDto especialidadPizza;
    private String idTamanioPizza;
    private TamanioPizzaDto tamanioPizza;
    private String idSucursal;
    private SucursalDto sucursal;
    private BigDecimal precio;
    private BigDecimal precioP1;
    private String aplica2x1;
    private String aplicaP1;
    private String aplicaBebidaChicaGratis;

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
     * @return the especialidadPizza
     */
    public EspecialidadPizzaDto getEspecialidadPizza() {
        return especialidadPizza;
    }

    /**
     * @param especialidadPizza the especialidadPizza to set
     */
    public void setEspecialidadPizza(EspecialidadPizzaDto especialidadPizza) {
        this.especialidadPizza = especialidadPizza;
    }

    /**
     * @return the idTamanioPizza
     */
    public String getIdTamanioPizza() {
        return idTamanioPizza;
    }

    /**
     * @param idTamanioPizza the idTamanioPizza to set
     */
    public void setIdTamanioPizza(String idTamanioPizza) {
        this.idTamanioPizza = idTamanioPizza;
    }

    /**
     * @return the tamanioPizza
     */
    public TamanioPizzaDto getTamanioPizza() {
        return tamanioPizza;
    }

    /**
     * @param tamanioPizza the tamanioPizza to set
     */
    public void setTamanioPizza(TamanioPizzaDto tamanioPizza) {
        this.tamanioPizza = tamanioPizza;
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
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    /**
     * @return the precioP1
     */
    public BigDecimal getPrecioP1() {
        return precioP1;
    }

    /**
     * @param precioP1 the precioP1 to set
     */
    public void setPrecioP1(BigDecimal precioP1) {
        this.precioP1 = precioP1;
    }

    /**
     * @return the aplica2x1
     */
    public String getAplica2x1() {
        return aplica2x1;
    }

    /**
     * @param aplica2x1 the aplica2x1 to set
     */
    public void setAplica2x1(String aplica2x1) {
        this.aplica2x1 = aplica2x1;
    }

    /**
     * @return the aplicaP1
     */
    public String getAplicaP1() {
        return aplicaP1;
    }

    /**
     * @param aplicaP1 the aplicaP1 to set
     */
    public void setAplicaP1(String aplicaP1) {
        this.aplicaP1 = aplicaP1;
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
