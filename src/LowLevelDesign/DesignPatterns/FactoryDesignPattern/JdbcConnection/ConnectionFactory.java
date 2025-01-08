package LowLevelDesign.DesignPatterns.FactoryDesignPattern.JdbcConnection;


public class ConnectionFactory {

    public static DatabaseConnection getConnection(String type) {

        switch(type.toLowerCase()) {
            case "mysql": return new MySQLConnection();
            case "oracle": return new OracleConnection();
            case "postgresql": return new PostgreSQLConnection();
            default: throw new IllegalArgumentException("Invalid connection type");
        }
    }
}
