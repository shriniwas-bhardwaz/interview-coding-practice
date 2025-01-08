package LowLevelDesign.DesignPatterns.ObjectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    Connection mySqlConnection;

    DBConnection() {
        try {
            mySqlConnection = DriverManager.getConnection("url","username","password");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
