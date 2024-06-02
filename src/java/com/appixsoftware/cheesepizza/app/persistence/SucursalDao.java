/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author LUIS.MU
 */
public class SucursalDao {

    public static SucursalDto dameSucursal(String sucursal) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<SucursalDto> h = new BeanHandler<SucursalDto>(SucursalDto.class);
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT id, clave, nombre_sucursal as nombreSucursal, rfc, domicilio, telefono, hora_inicio as horaInicio, hora_fin as horaFin, latitud, "
                + "longitud, id_lugar as idLugar,venta_activa as ventaActiva FROM preesppropro.sucursal WHERE id= ?;";
        Object[] params = {sucursal};
        SucursalDto e = qr.query(sql, h, params);
        return e;
    }

    public static SucursalDto getSucursal(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT id, clave, nombre_sucursal as nombreSucursal, rfc, domicilio, telefono, hora_inicio as horaInicio, hora_fin as horaFin, latitud, "
                + "longitud, id_lugar as idLugar,venta_activa as ventaActiva FROM preesppropro.sucursal WHERE clave= ?;";
        Object[] params = {clave};
        ResultSetHandler rsh = new BeanHandler(SucursalDto.class);
        SucursalDto s = (SucursalDto) qr.query(sql, rsh, params);
        return s;
    }

    public static SucursalDto getSucursal() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT id_sucursal, nombre_negocio, nombre_sucursal, "
                + "rfc_sucursal, domicilio_fiscal_sucursal, telefonos_sucursal "
                + "FROM cheesepizza.configuracion_local;";
        ResultSetHandler rsh = new BeanHandler(SucursalDto.class);
        SucursalDto s = (SucursalDto) qr.query(sql, rsh);
        return s;
    }

    public static List<SucursalDto> dameListaSucursales() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<SucursalDto>> h = new BeanListHandler<SucursalDto>(SucursalDto.class);
        String sql = null;
        List<SucursalDto> listaSucursales = null;
        sql = "SELECT id, clave, nombre_sucursal as nombreSucursal, rfc, domicilio, telefono, hora_inicio as horaInicio, hora_fin as horaFin, latitud, longitud, "
                + "id_lugar as idLugar,venta_activa as ventaActiva "
                + "FROM preesppropro.sucursal order by clave;";
        listaSucursales = qr.query(sql, h);
        // Cargando Sucursal
        for (SucursalDto s : listaSucursales) {
            s.setLugar(LugarDao.dameLugar(s.getIdLugar()));
        }

        return listaSucursales;
    }

    public static int insertaSucursalNueva(SucursalDto s) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "INSERT INTO preesppropro.sucursal(id, clave, nombre_sucursal, rfc, domicilio, telefono, hora_inicio, hora_fin, "
                + "latitud, longitud, id_lugar,venta_activa)	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
        regreso = qr.update(sql, s.getId(), s.getClave(), s.getNombreSucursal(), s.getRfc(), s.getDomicilio(), s.getTelefono(), 
                s.getHoraInicio(), s.getHoraFin(), s.getLatitud(), s.getLongitud(), s.getIdLugar(),s.getVentaActiva());
        return regreso;
    }

    public static int editaSucursal(SucursalDto l) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        //String sql = "UPDATE preesppropro.producto_tipo SET descripcion=? WHERE id=?";
        String sql = "UPDATE preesppropro.sucursal SET clave=?, nombre_sucursal=?, rfc=?, domicilio=?, "
                + "telefono=?, hora_inicio=?, hora_fin=?, latitud=?, longitud=?, id_lugar=?, venta_activa=? WHERE id=?;";
        regreso = qr.update(sql, l.getClave(), l.getNombreSucursal(), l.getRfc(), l.getDomicilio(), l.getTelefono(),
                l.getHoraInicio(), l.getHoraFin(), l.getLatitud(), l.getLongitud(), l.getIdLugar(),l.getVentaActiva(), l.getId());
        return regreso;
    }

    public static int borraSucursal(SucursalDto l) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.sucursal WHERE id=?";
        regreso = qr.update(sql, l.getId());
        return regreso;
    }
}
