/*
 * Sistema de Punto de Venta
 * Desarrollado para uso exclusivo de Cheese Pizza
 * Por Appix Software
 * Aguascalientes, México
 * (c) 2020
 */
package com.appixsoftware.cheesepizza.app.utils;

import com.appixsoftware.cheesepizza.app.persistence.ConfigurationLoader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author joseluis-mondragon
 */
public class UniqueKey {

    private static int seq = 0;

    public static String generateUniqueKey(String clave) throws SQLException {
        String uniqueKey;
        String sucursal = clave;
        uniqueKey = sucursal + generateUniqueLocalKey();
        return uniqueKey;        
    }  
    
//    public static String generateUniqueKey(String clave) throws SQLException {
//        String uniqueKey;
//        String sucursal = ConfigurationLoader.getConfiguration(clave).getClave();
//        uniqueKey = sucursal + generateUniqueLocalKey();
//        return uniqueKey;
//    }

    public static String generateUniqueKeyCombo() {
        return "" + (++seq);
    }

    public static String generateUniqueLocalKey() {
        String uniqueKey;
        Calendar calendar = new GregorianCalendar();
        String fecha = fix(calendar.get(GregorianCalendar.YEAR), 4)
                + fix(calendar.get(GregorianCalendar.MONTH) + 1, 2)
                + fix(calendar.get(GregorianCalendar.DAY_OF_MONTH), 2);
        String hora = fix(calendar.get(GregorianCalendar.HOUR_OF_DAY), 2)
                + fix(calendar.get(GregorianCalendar.MINUTE), 2)
                + fix(calendar.get(GregorianCalendar.SECOND), 2)
                + fix(calendar.get(GregorianCalendar.MILLISECOND), 3);
        String r = fix((int) Math.round(Math.random() * 1000000), 6);

        uniqueKey = fecha + hora + r;
        return uniqueKey;
    }

    public static String fix(int number, int c) {
        String n = number + "";
        int z = c - n.length();
        for (int i = 0; i < z; i++) {
            n = "0" + n;
        }
        return n;
    }

}
