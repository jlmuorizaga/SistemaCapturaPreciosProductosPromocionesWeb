/*
 * Sistema de Punto de Venta
 * Desarrollado para uso exclusivo de Cheese Pizza
 * Por Appix Software
 * Aguascalientes, México
 * (c) 2020
 */
package com.appixsoftware.cheesepizza.app.dto;

import java.io.Serializable;

/**
 *
 * @author luis_duron
 */
public class SucursalDto implements Serializable {

    /**
     * @return the lugar
     */
    private String id;
    private String clave;
    private String nombreSucursal;
    private String rfc;
    private String domicilio;
    private String telefono;
    private String horaInicio;
    private String horaFin;
    private Double latitud;
    private Double longitud;
    private String idLugar;
    private LugarDto lugar;
    private String ventaActiva;

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

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public String getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the latitud
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the idLugar
     */
    public String getIdLugar() {
        return idLugar;
    }

    /**
     * @param idLugar the idLugar to set
     */
    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public LugarDto getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(LugarDto lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the ventaActiva
     */
    public String getVentaActiva() {
        return ventaActiva;
    }

    /**
     * @param ventaActiva the ventaActiva to set
     */
    public void setVentaActiva(String ventaActiva) {
        this.ventaActiva = ventaActiva;
    }

}
