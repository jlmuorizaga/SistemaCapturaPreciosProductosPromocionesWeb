/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.RelacionEspecialidadTamanioPrecioSucursalDto;
import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
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
public class RelacionEspecialidadTamanioPrecioSucursalDao {

/*    public static List<RelacionEspecialidadTamanioPrecioSucursalDto> dameListaRelacionEspecialidadTamanioPrecioSucursal(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<RelacionEspecialidadTamanioPrecioSucursalDto>> h = new BeanListHandler<RelacionEspecialidadTamanioPrecioSucursalDto>(RelacionEspecialidadTamanioPrecioSucursalDto.class);
        String sql = null;
        List<RelacionEspecialidadTamanioPrecioSucursalDto> listaRelacionEspecialidadTamanioPrecioSucursal;
        //sql = "SELECT id, descripcion FROM preesppropro.producto_tipo WHERE id LIKE '%" + clave + "%' ORDER BY descripcion";
        sql = "SELECT id_especialidad_pizza as idEspecialidad, id_tamanio_pizza as idTamanioPizza, id_sucursal as idSucursal, precio "
                + "FROM preesppropro.relacion_especialidad_tamanio_precio_sucursal WHERE id_sucursal LIKE '%" + clave + "%' "
                + "ORDER BY id_especialidad_pizza, id_tamanio_pizza";
        listaRelacionEspecialidadTamanioPrecioSucursal = qr.query(sql, h);
        // Cargando Sucursal
        for (RelacionEspecialidadTamanioPrecioSucursalDto r : listaRelacionEspecialidadTamanioPrecioSucursal) {
            r.setEspecialidadPizza(EspecialidadPizzaDao.dameEspecialidadPizza(r.getIdEspecialidad()));
            r.setTamanioPizza(TamanioPizzaDao.dameTamanioPizza(r.getIdTamanioPizza()));
            r.setSucursal(SucursalDao.dameSucursal(r.getIdSucursal()));
        }
        return listaRelacionEspecialidadTamanioPrecioSucursal;
    }
  */  
        public static List<RelacionEspecialidadTamanioPrecioSucursalDto> dameListaRelacionEspecialidadTamanioPrecioSucursal(String clave) throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        ResultSetHandler<List<RelacionEspecialidadTamanioPrecioSucursalDto>> h = new BeanListHandler<RelacionEspecialidadTamanioPrecioSucursalDto>(RelacionEspecialidadTamanioPrecioSucursalDto.class);
        String sql = null;
        List<RelacionEspecialidadTamanioPrecioSucursalDto> listaRelacionEspecialidadTamanioPrecioSucursal;
        
        sql="SELECT id_especialidad_pizza as idEspecialidad, ep.nombre as pizzaNombre,"
                + "id_tamanio_pizza as idTamanioPizza, tp.nombre as pizzaTamanio,id_sucursal as idSucursal, precio,precio_p1 as precioP1,"
                + "r.aplica_2x1 as aplica2x1, r.aplica_p1 as aplicaP1,r.aplica_bebida_chica_gratis as aplicaBebidaChicaGratis "
                + "FROM preesppropro.relacion_especialidad_tamanio_precio_sucursal r,preesppropro.especialidad_pizza ep,preesppropro.tamanio_pizza tp "
                + "WHERE id_sucursal LIKE '%" + clave + "%' "
                + "AND id_especialidad_pizza=ep.id AND id_tamanio_pizza=tp.id "
                + "ORDER BY pizzaNombre, pizzaTamanio";        
        listaRelacionEspecialidadTamanioPrecioSucursal = qr.query(sql, h);
        // Cargando Sucursal
        for (RelacionEspecialidadTamanioPrecioSucursalDto r : listaRelacionEspecialidadTamanioPrecioSucursal) {
            r.setEspecialidadPizza(EspecialidadPizzaDao.dameEspecialidadPizza(r.getIdEspecialidad()));
            r.setTamanioPizza(TamanioPizzaDao.dameTamanioPizza(r.getIdTamanioPizza()));
            r.setSucursal(SucursalDao.dameSucursal(r.getIdSucursal()));
        }
        return listaRelacionEspecialidadTamanioPrecioSucursal;
    }

    public static int insertaRelacionEspecialidadTamanioPrecioSucursal(RelacionEspecialidadTamanioPrecioSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "INSERT INTO preesppropro.relacion_especialidad_tamanio_precio_sucursal"
                + "(id_especialidad_pizza,id_tamanio_pizza, id_sucursal, precio,precio_p1,aplica_2x1,aplica_p1,aplica_bebida_chica_gratis) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        regreso = qr.update(sql, r.getIdEspecialidad(), r.getIdTamanioPizza(), r.getIdSucursal(), r.getPrecio(),r.getPrecioP1(),r.getAplica2x1(),
                r.getAplicaP1(),r.getAplicaBebidaChicaGratis());
        return regreso;
    }

    public static int editaRelacionEspecialidadTamanioPrecioSucursal(RelacionEspecialidadTamanioPrecioSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "UPDATE preesppropro.relacion_especialidad_tamanio_precio_sucursal "
                + "	SET id_especialidad_pizza=?, id_tamanio_pizza=?, id_sucursal=?, precio=?, precio_p1=?, aplica_2x1=?, aplica_p1=?, aplica_bebida_chica_gratis=?  "
                + "WHERE id_especialidad_pizza=? and id_tamanio_pizza=? and id_sucursal=?";
        regreso = qr.update(sql, r.getIdEspecialidad(), r.getIdTamanioPizza(), r.getIdSucursal(), r.getPrecio(), r.getPrecioP1(),r.getAplica2x1(),
                r.getAplicaP1(),r.getAplicaBebidaChicaGratis(),r.getIdEspecialidad(), r.getIdTamanioPizza(), r.getIdSucursal());
        return regreso;
    }

    public static int borraRelacionEspecialidadTamanioPrecioSucursal(RelacionEspecialidadTamanioPrecioSucursalDto r) throws SQLException {
        int regreso = 0;
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "DELETE FROM preesppropro.relacion_especialidad_tamanio_precio_sucursal WHERE id_especialidad_pizza=? and id_tamanio_pizza=? and id_sucursal=?";
        regreso = qr.update(sql, r.getIdEspecialidad(), r.getIdTamanioPizza(), r.getIdSucursal());
        return regreso;
    }

}
