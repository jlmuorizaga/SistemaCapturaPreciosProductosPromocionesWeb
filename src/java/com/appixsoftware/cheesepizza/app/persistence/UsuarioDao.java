/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.UsuarioDto;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *
 * @author LUIS.MU
 */
public class UsuarioDao {
    public static UsuarioDto dameUsuario(UsuarioDto usuario) {
        try {
            DataSource ds = DataSourceAdministrator.getDataSource();
            QueryRunner qr = new QueryRunner(ds);
            ResultSetHandler rsh = new BeanHandler(UsuarioDto.class
            );
            String sql = "SELECT id, usuario, contrasenia, nombre "
                    + "FROM preesppropro.usuario WHERE usuario = ? AND contrasenia = ?;";
            Object[] params = {usuario.getUsuario(),usuario.getContrasenia()};
            usuario = (UsuarioDto) qr.query(sql, rsh, params);
            return usuario;
        } catch (SQLException ex) {
            return null;
        }
    }    
    
}
