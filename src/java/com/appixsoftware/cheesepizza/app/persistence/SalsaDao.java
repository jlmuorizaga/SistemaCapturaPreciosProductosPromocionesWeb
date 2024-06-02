/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.SalsaDto;
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
public class SalsaDao {

    public static SalsaDto dameSalsa(String id) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<SalsaDto> h = new BeanHandler<SalsaDto>(SalsaDto.class);
        QueryRunner qr = new QueryRunner(ds);
        String sql="SELECT id, descripcion FROM preesppropro.salsa WHERE id=? ";
        Object[] params = {id};
        SalsaDto e = qr.query(sql, h, params);
        return e;
    }    
    public static List<SalsaDto> dameListaSalsa() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<SalsaDto>> h = new BeanListHandler<>(SalsaDto.class);
        String sql = null;
        List<SalsaDto> listaSalsa = null;
        //sql = "SELECT id, descripcion FROM preesppropro.salsa WHERE id LIKE '%"+clave+"%' ORDER BY descripcion";
         sql = "SELECT id, descripcion FROM preesppropro.salsa ORDER BY descripcion";
        listaSalsa = qr.query(sql, h);
        return listaSalsa;
    }
    
    public static int insertaSalsaNuevo(SalsaDto s) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql="INSERT INTO preesppropro.salsa(id, descripcion) VALUES (?, ?);";
        regreso = qr.update(sql, s.getId(), s.getDescripcion());
        return regreso;
    }
    
    public static int editaSalsa(SalsaDto s) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "UPDATE preesppropro.salsa SET descripcion=? WHERE id=?";
        regreso = qr.update(sql, s.getDescripcion(), s.getId());
        return regreso;
    }    
    
        public static int borraSalsa(SalsaDto s) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.salsa WHERE id=?";
        regreso = qr.update(sql, s.getId());
        return regreso;
    }
    
}
