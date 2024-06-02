/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.ProductoTipoDto;
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
public class ProductoTipoDao {

    public static List<ProductoTipoDto> dameListaProductoTipo(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<ProductoTipoDto>> h = new BeanListHandler<ProductoTipoDto>(ProductoTipoDto.class);
        String sql = null;
        List<ProductoTipoDto> listaProductoTipo = null;
        //sql = "SELECT id, descripcion FROM preesppropro.producto_tipo WHERE id LIKE '%" + clave + "%' ORDER BY descripcion";
        sql = "SELECT id, descripcion FROM preesppropro.producto_tipo ORDER BY descripcion";
        listaProductoTipo = qr.query(sql, h);
        return listaProductoTipo;
    }

    public static int insertaProductoTipoNuevo(ProductoTipoDto p) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "INSERT INTO preesppropro.producto_tipo(id, descripcion) VALUES (?, ?);";
        regreso = qr.update(sql, p.getId(), p.getDescripcion());
        return regreso;
    }

    public static int editaProductoTipo(ProductoTipoDto p) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "UPDATE preesppropro.producto_tipo SET descripcion=? WHERE id=?";
        regreso = qr.update(sql, p.getDescripcion(), p.getId());
        return regreso;
    }

    public static int borraProductoTipo(ProductoTipoDto p) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.producto_tipo WHERE id=?";
        regreso = qr.update(sql, p.getId());
        return regreso;
    }
    
    public static ProductoTipoDto dameProductoTipo(String id) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<ProductoTipoDto> h = new BeanHandler<ProductoTipoDto>(ProductoTipoDto.class);
        QueryRunner qr = new QueryRunner(ds);
        String sql="SELECT id, descripcion FROM preesppropro.producto_tipo WHERE id=?";
        Object[] params = {id};
        ProductoTipoDto t = qr.query(sql, h, params);
        return t;
    }       

}
