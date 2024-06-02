/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.EspecialidadPizzaDto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author LUIS.MU
 */
public class EspecialidadPizzaDao {
 public static List<EspecialidadPizzaDto> dameListaEspecialidadPizza() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<EspecialidadPizzaDto>> h = new BeanListHandler<>(EspecialidadPizzaDto.class);
        String sql = null;
        List<EspecialidadPizzaDto> listaEspecialidadPizza = null;
        sql="SELECT id as idEspecialidad, nombre as nombreEspecialidad, ingredientes as ingredientesEspecialidad, aplica_2x1 as aplica2x1Especialidad,aplica_p1 as aplicaP1Especialidad, img_url as imgUrl  FROM preesppropro.especialidad_pizza ORDER BY nombre";
        listaEspecialidadPizza = qr.query(sql, h);
        return listaEspecialidadPizza;
    }
    
    public static int insertaEspecialidadPizza(EspecialidadPizzaDto e) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql="INSERT INTO preesppropro.especialidad_pizza(id, nombre, ingredientes,aplica_2x1,aplica_p1,img_url) VALUES (?, ?, ?, ?);";
        regreso = qr.update(sql, e.getIdEspecialidad(), e.getNombreEspecialidad(),e.getIngredientesEspecialidad(),e.getAplica2x1Especialidad(),e.getAplicaP1Especialidad(),e.getImgUrl());
        return regreso;
    }
    
    public static int editaEspecialidadPizza(EspecialidadPizzaDto e) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql="UPDATE preesppropro.especialidad_pizza SET id=?, nombre=?, ingredientes=?, aplica_2x1=?, aplica_p1=?, img_url=? WHERE id=?";
        regreso = qr.update(sql, e.getIdEspecialidad(),e.getNombreEspecialidad(),e.getIngredientesEspecialidad(),e.getAplica2x1Especialidad(),e.getAplicaP1Especialidad(),e.getImgUrl(),e.getIdEspecialidad());
        return regreso;
    }    
    
        public static int borraEspecialidadPizza(EspecialidadPizzaDto e) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.especialidad_pizza WHERE id=?";
        regreso = qr.update(sql, e.getIdEspecialidad());
        return regreso;
    }
    
    public static EspecialidadPizzaDto dameEspecialidadPizza(String idLugar) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        ResultSetHandler<EspecialidadPizzaDto> h = new BeanHandler<EspecialidadPizzaDto>(EspecialidadPizzaDto.class);
        QueryRunner qr = new QueryRunner(ds);
        //String sql = "SELECT id as idEspecialidad, nombre as nombreEspecialidad, ingredientes as ingredientesEspecialidad, imagen as imagenEspecialidad FROM preesppropro.especialidad_pizza WHERE id=?";
        String sql = "SELECT id as idEspecialidad, nombre as nombreEspecialidad, ingredientes as ingredientesEspecialidad,aplica_2x1 as aplica2x1Especialidad, aplica_p1 as aplicaP1Especialidad FROM preesppropro.especialidad_pizza WHERE id=? ORDER by nombre";
        Object[] params = {idLugar};
        EspecialidadPizzaDto e = qr.query(sql, h, params);
        return e;
    }        

}
