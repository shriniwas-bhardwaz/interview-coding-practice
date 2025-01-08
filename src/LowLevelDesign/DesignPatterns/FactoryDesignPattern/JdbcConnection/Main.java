package LowLevelDesign.DesignPatterns.FactoryDesignPattern.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

       DatabaseConnection mySqlConnection = ConnectionFactory.getConnection("MySQl");
       Connection mySqlCon = mySqlConnection.createConnection();

       System.out.println("Connection established" + mySqlCon);
       mySqlCon.close();
    }
}
