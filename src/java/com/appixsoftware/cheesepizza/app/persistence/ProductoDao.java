/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.ProductoDto;
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
public class ProductoDao {

    public static ProductoDto dameProducto(String id) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<ProductoDto> h = new BeanHandler<ProductoDto>(ProductoDto.class);
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT id, descripcion, tamanio, usa_salsa as usaSalsa, id_tipo_producto as idTipoProducto FROM preesppropro.producto WHERE id=? "
                + "ORDER BY descripcion ASC";
        Object[] params = {id};
        ProductoDto e = qr.query(sql, h, params);
        return e;
    }

    public static List<ProductoDto> dameListaProductos() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<ProductoDto>> h = new BeanListHandler<ProductoDto>(ProductoDto.class);
        String sql = null;
        List<ProductoDto> listaProductos = null;
        sql = "SELECT id, descripcion, tamanio, usa_salsa as usaSalsa, id_tipo_producto as idTipoProducto FROM preesppropro.producto order by descripcion";
        listaProductos = qr.query(sql, h);
        for (ProductoDto p : listaProductos) {
            p.setProductoTipo(ProductoTipoDao.dameProductoTipo(p.getIdTipoProducto()));
        }
        return listaProductos;
    }

    public static int insertaProductoNuevo(ProductoDto p) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "INSERT INTO preesppropro.producto(id, descripcion, tamanio, usa_salsa, id_tipo_producto) VALUES (?, ?, ?, ?, ?);";
        regreso = qr.update(sql, p.getId(), p.getDescripcion(), p.getTamanio(), p.getUsaSalsa(), p.getIdTipoProducto());
        return regreso;
    }

    public static int editaProducto(ProductoDto p) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "UPDATE preesppropro.producto SET descripcion=?, tamanio=?, usa_salsa=?, id_tipo_producto=? WHERE id=?";
        regreso = qr.update(sql, p.getDescripcion(), p.getTamanio(), p.getUsaSalsa(), p.getIdTipoProducto(), p.getId());
        return regreso;
    }
    
    public static int borraProducto(ProductoDto p) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.producto WHERE id=?";
        regreso = qr.update(sql, p.getId());
        return regreso;
    }    

}
