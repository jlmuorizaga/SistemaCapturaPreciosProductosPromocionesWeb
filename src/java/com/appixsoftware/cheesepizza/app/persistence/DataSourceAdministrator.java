/*
 * Sistema de Punto de Venta
 * Desarrollado para uso exclusivo de Cheese Pizza
 * Por Appix Software
 * Aguascalientes, México
 * (c) 2020
 */
package com.appixsoftware.cheesepizza.app.persistence;

//import cheesepizzapv.LoggerCHP;
//import com.appixsoftware.cheesepizza.app.business.AdministradorJson;
//import com.appixsoftware.cheesepizza.app.dto.Impresora;
//import com.appixsoftware.cheesepizza.app.utils.DialogoExcepcion;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author joseluis.mondragon
 */
public class DataSourceAdministrator implements Serializable {

    private static DataSource dsp;

    public static synchronized DataSource getDataSource() {
        if (dsp == null) {

            BasicDataSource bds = new BasicDataSource();
            //String ipBaseDatos = null;

            bds.setDriverClassName("org.postgresql.Driver");

            //AWS
            //bds.setUrl("jdbc:postgresql://database-1.cgujpjkz4fsl.us-west-1.rds.amazonaws.com:5432/chppreciosespecprodpromocdb");
            //Oficina
            //bds.setUrl("jdbc:postgresql://localhost:5433/chppreciosespecprodpromocdb");
            //Casa
            bds.setUrl("jdbc:postgresql://localhost:5432/chppreciosespecprodpromocdb");
            bds.setUsername("cheesepizzauser");
            bds.setPassword("cheesepizza2001");

            bds.setTimeBetweenEvictionRunsMillis(10000);
            bds.setMaxTotal(50);
            bds.setMaxIdle(8);
            bds.setMinIdle(3);
            bds.setTestWhileIdle(true);
            bds.setValidationQuery("select 1 as uno;");
            bds.setRemoveAbandonedTimeout(5);
            bds.setRemoveAbandonedOnBorrow(true);
            bds.setMaxWaitMillis(5000);

            dsp = bds;
        }
        return dsp;
    }

}
