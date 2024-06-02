/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.RelacionProductoSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.RelacionPromocionEspecialSucursalDto;
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
public class RelacionPromocionEspecialSucursalDao {

    public static List<RelacionPromocionEspecialSucursalDto> dameListaRelacionPromocionEspecialSucursal(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<RelacionPromocionEspecialSucursalDto>> h = new BeanListHandler<RelacionPromocionEspecialSucursalDto>(RelacionPromocionEspecialSucursalDto.class);
        String sql = null;
        List<RelacionPromocionEspecialSucursalDto> listaRelacionPromocionSucursal;
        sql ="SELECT id_promocion as idPromocion, id_sucursal as idSucursal, activa "
                + "FROM preesppropro.relacion_promocion_especial_sucursal WHERE id_sucursal LIKE '%" + clave + "%'";
        listaRelacionPromocionSucursal = qr.query(sql, h);
        // Cargando Sucursal
        for (RelacionPromocionEspecialSucursalDto r : listaRelacionPromocionSucursal) {
            r.setPromocion(PromocionEspecialDao.damePromocionEspecial(r.getIdPromocion()));
            r.setSucursal(SucursalDao.dameSucursal(r.getIdSucursal()));
        }
        return listaRelacionPromocionSucursal;
    }

    public static int insertaRelacionPromocionEspecialSucursal(RelacionPromocionEspecialSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql="INSERT INTO preesppropro.relacion_promocion_especial_sucursal(id_promocion, id_sucursal, activa) VALUES (?, ?, ?)";
        regreso = qr.update(sql, r.getIdPromocion(), r.getIdSucursal(), r.getActiva());
        return regreso;
    }

    public static int editaRelacionPromocionEspecialSucursal(RelacionPromocionEspecialSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql="UPDATE preesppropro.relacion_promocion_especial_sucursal SET id_promocion=?, id_sucursal=?, activa=? "
                + "WHERE id_promocion=? and id_sucursal=?;";
        regreso = qr.update(sql, r.getIdPromocion(), r.getIdSucursal(), r.getActiva(), r.getIdPromocion(), r.getIdSucursal());
        return regreso;
    }

    public static int borraRelacionPromocionEspecialSucursal(RelacionPromocionEspecialSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql="DELETE FROM preesppropro.relacion_promocion_especial_sucursal WHERE id_promocion=? and id_sucursal=?";
        regreso = qr.update(sql, r.getIdPromocion(), r.getIdSucursal());
        return regreso;
    }

}
