/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.TamanioPizzaDto;
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
public class TamanioPizzaDao {
/*    public static List<TamanioPizzaDto> dameListaTamanioPizza(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<TamanioPizzaDto>> h = new BeanListHandler<TamanioPizzaDto>(TamanioPizzaDto.class);
        String sql = null;
        List<TamanioPizzaDto> listaTamanioPizza = null;
        sql = "SELECT id, nombre FROM preesppropro.tamanio_pizza WHERE id LIKE '%"+clave+"%' ORDER BY nombre";        
        listaTamanioPizza = qr.query(sql, h);
        return listaTamanioPizza;
    }*/
    public static List<TamanioPizzaDto> dameListaTamanioPizza(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<TamanioPizzaDto>> h = new BeanListHandler<TamanioPizzaDto>(TamanioPizzaDto.class);
        String sql = null;
        List<TamanioPizzaDto> listaTamanioPizza = null;
//        Object[] params = {clave};
        sql = "SELECT id, nombre FROM preesppropro.tamanio_pizza ORDER BY nombre";        
        //aplica_2x1 as aplica2x1, aplica_p1 as aplicaP1 
        listaTamanioPizza = qr.query(sql, h);
        return listaTamanioPizza;
    }    
    
    public static int insertaTamanioPizzaNuevo(TamanioPizzaDto t) throws SQLException {
        int regreso = 0;

        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "INSERT INTO preesppropro.tamanio_pizza(id, nombre) VALUES (?, ?);";
        regreso = qr.update(sql,t.getId(), t.getNombre());
        return regreso;
    }    
    
    public static int editaTamanioPizza(TamanioPizzaDto t) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "UPDATE preesppropro.tamanio_pizza SET nombre=? WHERE id=?";
        regreso = qr.update(sql,t.getNombre(),t.getId());
        return regreso;
    }
    
    public static int borraTamanioPizza(TamanioPizzaDto t) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.tamanio_pizza WHERE id=?";
        regreso = qr.update(sql,t.getId());
        return regreso;
    }

    public static TamanioPizzaDto dameTamanioPizza(String id) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<TamanioPizzaDto> h = new BeanHandler<TamanioPizzaDto>(TamanioPizzaDto.class);
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT id, nombre	FROM preesppropro.tamanio_pizza WHERE id=?";
        Object[] params = {id};
        TamanioPizzaDto t = qr.query(sql, h, params);
        return t;
    }    
    
    
}
