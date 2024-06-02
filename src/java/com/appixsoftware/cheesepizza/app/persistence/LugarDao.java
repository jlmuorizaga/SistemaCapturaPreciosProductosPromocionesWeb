/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.LugarDto;
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
public class LugarDao {

    public static List<LugarDto> dameListaLugar() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<LugarDto>> h = new BeanListHandler<LugarDto>(LugarDto.class);
        String sql = null;
        List<LugarDto> lugar = null;
        sql = "SELECT id, nombre FROM preesppropro.lugar ORDER BY nombre";
        lugar = qr.query(sql, h);
        return lugar;
    }

    public static int insertaLugarNuevo(LugarDto l) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        //String sql = "INSERT INTO preesppropro.producto_tipo(id, descripcion) VALUES (?, ?);";
        String sql = "INSERT INTO preesppropro.lugar(id, nombre)VALUES (?, ?)";
        regreso = qr.update(sql, l.getId(), l.getNombre());
        return regreso;
    }

    public static int editaLugar(LugarDto l) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        //String sql = "UPDATE preesppropro.producto_tipo SET descripcion=? WHERE id=?";
        String sql = "UPDATE preesppropro.lugar SET nombre=? WHERE id=?";
        regreso = qr.update(sql, l.getNombre(), l.getId());
        return regreso;
    }

    public static int borraLugar(LugarDto l) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.lugar WHERE id=?";
        regreso = qr.update(sql, l.getId());
        return regreso;
    }

    public static LugarDto dameLugar(String idLugar) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<LugarDto> h = new BeanHandler<LugarDto>(LugarDto.class);
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT id, nombre	FROM preesppropro.lugar WHERE id=?";
        Object[] params = {idLugar};
        LugarDto l = qr.query(sql, h, params);
        return l;
    }
}
