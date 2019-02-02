package com.github.enriqueabsurdum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    public Connection getConnect() {
        Connection connect = null;
        String cfn = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/adelta_technology";
        String user = "root";
        String pass = "root";
        try {
            Class.forName(cfn);
            connect = DriverManager.getConnection(url, user, pass);
            System.out.printf("Successful connection\n");
        } catch (SQLException sqle) {
            System.out.printf("Connection error: %sn", sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.printf("Driver error: %sn", cnfe.getMessage());
        }
        return connect;
    }
}
