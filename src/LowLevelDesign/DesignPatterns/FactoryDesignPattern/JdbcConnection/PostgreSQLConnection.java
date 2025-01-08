package LowLevelDesign.DesignPatterns.FactoryDesignPattern.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection implements DatabaseConnection{

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "user", "password");
    }
}
