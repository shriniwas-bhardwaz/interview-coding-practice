package LowLevelDesign.DesignPatterns.ObjectPoolDesignPattern;

public class Client {

    public static void main(String[] args) {

        DBConnectionPoolManager dbConnectionPoolManager = DBConnectionPoolManager.getInstance();

        DBConnection dbConnection1 = dbConnectionPoolManager.getDBConnection();
        DBConnection dbConnection2 = dbConnectionPoolManager.getDBConnection();
        DBConnection dbConnection3 = dbConnectionPoolManager.getDBConnection();
        DBConnection dbConnection4 = dbConnectionPoolManager.getDBConnection();
        DBConnection dbConnection5 = dbConnectionPoolManager.getDBConnection();
        DBConnection dbConnection6 = dbConnectionPoolManager.getDBConnection();

        dbConnectionPoolManager.getDBConnection();
        dbConnectionPoolManager.releaseDBConnection(dbConnection6);


    }
}
