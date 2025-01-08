package LowLevelDesign.DesignPatterns.FactoryDesignPattern.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {

    public Connection createConnection() throws SQLException;
}
