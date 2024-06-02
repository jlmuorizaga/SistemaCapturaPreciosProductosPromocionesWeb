/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appixsoftware.cheesepizza.app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LUIS.MU
 */
public class Conexion {

    Connection con;

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://database-1.cgujpjkz4fsl.us-west-1.rds.amazonaws.com:5432/chppreciosespecprodpromocdb", "cheesepizzauser", "cheesepizza2001");
        } catch (ClassNotFoundException | SQLException e) {

        }
        return con;
    }

}
