/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.RelacionSalsaSucursalDto;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author jlmuo
 */
public class RelacionSalsaSucursalDao {

    public static List<RelacionSalsaSucursalDto> dameListaRelacionSalsaSucursal(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<RelacionSalsaSucursalDto>> h = new BeanListHandler<RelacionSalsaSucursalDto>(RelacionSalsaSucursalDto.class);
        String sql = null;
        List<RelacionSalsaSucursalDto> listaRelacionSalsaSucursal;
        sql = "SELECT id_salsa as idSalsa, id_sucursal as idSucursal "
                + "FROM preesppropro.relacion_salsa_sucursal WHERE id_sucursal LIKE '%" + clave + "%'";
        listaRelacionSalsaSucursal = qr.query(sql, h);
        // Cargando Sucursal
        for (RelacionSalsaSucursalDto r : listaRelacionSalsaSucursal) {
            r.setSalsa(SalsaDao.dameSalsa(r.getIdSalsa()));
            r.setSucursal(SucursalDao.dameSucursal(r.getIdSucursal()));
        }
        return listaRelacionSalsaSucursal;
    }

    public static int insertaRelacionSalsaSucursal(RelacionSalsaSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "INSERT INTO preesppropro.relacion_salsa_sucursal(id_salsa, id_sucursal) VALUES (?, ?);";
        regreso = qr.update(sql, r.getIdSalsa(), r.getIdSucursal());
        return regreso;
    }

    public static int editaRelacionSalsaSucursal(RelacionSalsaSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "UPDATE preesppropro.relacion_salsa_sucursal SET id_salsa=?, id_sucursal=? WHERE id_salsa=? and id_sucursal=?;";
        regreso = qr.update(sql, r.getIdSalsa(), r.getIdSucursal(), r.getIdSalsa(), r.getIdSucursal());
        return regreso;
    }

    public static int borraRelacionSalsaSucursal(RelacionSalsaSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.relacion_salsa_sucursal WHERE id_salsa=? and id_sucursal=?";
        regreso = qr.update(sql, r.getIdSalsa(), r.getIdSucursal());
        return regreso;
    }
    
    
}
