package LowLevelDesign.DesignPatterns.FactoryDesignPattern.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection implements DatabaseConnection{
    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "user", "password");
    }
}
