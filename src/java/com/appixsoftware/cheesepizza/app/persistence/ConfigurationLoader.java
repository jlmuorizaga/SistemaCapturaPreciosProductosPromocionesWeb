/*
 * Sistema de Punto de Venta
 * Desarrollado para uso exclusivo de Cheese Pizza
 * Por Appix Software
 * Aguascalientes, México
 * (c) 2020
 */
package com.appixsoftware.cheesepizza.app.persistence;

import com.appixsoftware.cheesepizza.app.dto.SucursalDto;
import java.io.Serializable;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *
 * @author joseluis-mondragon
 */
public class ConfigurationLoader implements Serializable {

    private static Configuration conf;

    public static Configuration getConfiguration(String clave) throws SQLException {
        if (conf != null) {
            return conf;
        } else {
            //Read the configuration fron the database
            DataSource ds = DataSourceAdministrator.getDataSource();
            QueryRunner qr = new QueryRunner(ds);
            ResultSetHandler<Configuration> h = new BeanHandler<>(Configuration.class);
            String sql = "SELECT clave as clave, nombre_sucursal as nombreSucursal FROM preesppropro.sucursal WHERE clave=? ;";
            Configuration query = qr.query(sql, h);
            conf = query;

            return conf;
        }
    }

    public static SucursalDto getSucursal() throws SQLException {
        DataSource ds = DataSourceAdministrator.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "SELECT id_sucursal, nombre_negocio, nombre_sucursal, "
                + "rfc_sucursal, domicilio_fiscal_sucursal, telefonos_sucursal "
                + "FROM cheesepizza.configuracion_local;";
        ResultSetHandler rsh = new BeanHandler(SucursalDto.class);
        SucursalDto s = (SucursalDto) qr.query(sql, rsh);
        return s;
    }

}
