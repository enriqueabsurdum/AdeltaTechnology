package com.github.enriqueabsurdum.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseResource {

    public static void closeConnection(Connection connection, PreparedStatement sentence, ResultSet result) {
        try {
            if (result != null) {
                result.close();
            }
            if (sentence != null) {
                sentence.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.printf("Close connection\n");
        } catch (SQLException sqle) {
            System.out.printf("Close connection error: ", sqle.getMessage());
        }
    }
}
