/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.RelacionProductoSucursalDto;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author LUIS.MU
 */
public class RelacionProductoSucursalDao {
    
    public static List<RelacionProductoSucursalDto> dameListaRelacionProductoSucursal(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<RelacionProductoSucursalDto>> h = new BeanListHandler<RelacionProductoSucursalDto>(RelacionProductoSucursalDto.class);
        String sql = null;
        List<RelacionProductoSucursalDto> listaRelacionProductoSucursal;
        sql = "SELECT id_producto as idProducto, id_sucursal as idSucursal, precio_normal as precioNormal,aplica_bebida_chica_gratis as aplicaBebidaChicaGratis "
                + "FROM preesppropro.relacion_producto_sucursal WHERE id_sucursal LIKE '%" + clave + "%'";
        listaRelacionProductoSucursal = qr.query(sql, h);
        // Cargando Sucursal
        for (RelacionProductoSucursalDto r : listaRelacionProductoSucursal) {
            r.setProducto(ProductoDao.dameProducto(r.getIdProducto()));
            r.setSucursal(SucursalDao.dameSucursal(r.getIdSucursal()));
        }
        return listaRelacionProductoSucursal;
    }
    
 public static int insertaRelacionProductoSucursal(RelacionProductoSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "INSERT INTO preesppropro.relacion_producto_sucursal(id_producto, id_sucursal, precio_normal,aplica_bebida_chica_gratis) VALUES (?, ?, ?, ?);";
        regreso = qr.update(sql, r.getIdProducto(), r.getIdSucursal(), r.getPrecioNormal(),r.getAplicaBebidaChicaGratis());
        return regreso;
    }

    public static int editaRelacionProductoSucursal(RelacionProductoSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "UPDATE preesppropro.relacion_producto_sucursal SET id_producto=?, id_sucursal=?, precio_normal=?, aplica_bebida_chica_gratis=? WHERE id_producto=? and id_sucursal=?;";
        regreso = qr.update(sql, r.getIdProducto(), r.getIdSucursal(), r.getPrecioNormal(),r.getAplicaBebidaChicaGratis(),r.getIdProducto(),r.getIdSucursal());
        return regreso;
    }

    public static int borraRelacionProductoSucursal(RelacionProductoSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.relacion_producto_sucursal WHERE id_producto=? and id_sucursal=?";
        regreso = qr.update(sql, r.getIdProducto(), r.getIdSucursal());
        return regreso;
    }
    
    
}
