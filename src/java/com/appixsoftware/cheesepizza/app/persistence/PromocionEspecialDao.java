/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.PromocionEspecialDto;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author jlmuo
 */
public class PromocionEspecialDao {
    
        public static PromocionEspecialDto damePromocionEspecial(String id) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<PromocionEspecialDto> h = new BeanHandler<PromocionEspecialDto>(PromocionEspecialDto.class);
        QueryRunner qr = new QueryRunner(ds);        
        String sql = "SELECT id, definicion FROM preesppropro.catalogo_promocion_especial WHERE id=?";
        Object[] params = {id};
        PromocionEspecialDto e = qr.query(sql, h, params);
        return e;
    }

    public static List<PromocionEspecialDto> dameListaPromocionEspecial() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<PromocionEspecialDto>> h = new BeanListHandler<PromocionEspecialDto>(PromocionEspecialDto.class);
        String sql = null;
        List<PromocionEspecialDto> listaPromocionEspecial = null;
        sql = "SELECT id, definicion FROM preesppropro.catalogo_promocion_especial order by definicion";
        listaPromocionEspecial = qr.query(sql, h);
        return listaPromocionEspecial;
    }

//    public static int insertaPromocionEspecialNueva(PromocionEspecialDto p) throws SQLException {
//        int regreso = 0;
//        DataSource ds = DataSourceAdministrator.getDataSource();
//        QueryRunner qr = new QueryRunner(ds);
//        String sql = "INSERT INTO preesppropro.producto(id, descripcion, tamanio, usa_sabor, id_tipo_producto) VALUES (?, ?, ?, ?, ?);";
//        regreso = qr.update(sql, p.getId(), p.getDescripcion(), p.getTamanio(), p.getUsaSabor(), p.getIdTipoProducto());
//        return regreso;
//    }

//    public static int editaProducto(ProductoDto p) throws SQLException {
//        int regreso = 0;
//        DataSource ds = DataSourceAdministrator.getDataSource();
//        QueryRunner qr = new QueryRunner(ds);
//        String sql = "UPDATE preesppropro.producto SET descripcion=?, tamanio=?, usa_sabor=?, id_tipo_producto=? WHERE id=?";
//        regreso = qr.update(sql, p.getDescripcion(), p.getTamanio(), p.getUsaSabor(), p.getIdTipoProducto(), p.getId());
//        return regreso;
//    }
    
//    public static int borraProducto(ProductoDto p) throws SQLException {
//        int regreso = 0;
//        DataSource ds = DataSourceAdministrator.getDataSource();
//        QueryRunner qr = new QueryRunner(ds);
//        String sql = "DELETE FROM preesppropro.producto WHERE id=?";
//        regreso = qr.update(sql, p.getId());
//        return regreso;
//    }    

    
}
