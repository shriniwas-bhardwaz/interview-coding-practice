package LowLevelDesign.DesignPatterns.ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DBConnectionPoolManager {

    List<DBConnection> freeConnectionsPool = new ArrayList<>();
    List<DBConnection> connectionCurrentlyInUse = new ArrayList<>();
    int INITIAL_POOL_SIZE = 3;
    int MAX_POOL_SIZE = 6;
    private static DBConnectionPoolManager dbConnectionPoolManagerInstance = null;

    private DBConnectionPoolManager() {
        for(int i=0;i<INITIAL_POOL_SIZE;i++) {
            freeConnectionsPool.add(new DBConnection());
        }
    }

    public static DBConnectionPoolManager getInstance() {
        if(dbConnectionPoolManagerInstance == null) {
            synchronized (DBConnectionPoolManager.class) {
                if(dbConnectionPoolManagerInstance == null) {
                    dbConnectionPoolManagerInstance = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManagerInstance;
    }

    public synchronized DBConnection getDBConnection() {
        if(freeConnectionsPool.isEmpty() && connectionCurrentlyInUse.size()<MAX_POOL_SIZE) {
            freeConnectionsPool.add(new DBConnection());
            System.out.println("creating new connection and putting into the pool, free pool size: " + freeConnectionsPool.size());
        } else if(freeConnectionsPool.isEmpty() && connectionCurrentlyInUse.size()>=MAX_POOL_SIZE) {
            System.out.println("can not create new DB connection, as max limit reached");
            return null;
        }

        DBConnection dbConnection = freeConnectionsPool.remove(freeConnectionsPool.size()-1);
        connectionCurrentlyInUse.add(dbConnection);
       System.out.println("Adding db connections into Use Pool, size: " + connectionCurrentlyInUse.size());
        return  dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection) {
       if(dbConnection != null) {
           connectionCurrentlyInUse.remove(dbConnection);
           System.out.println("Removing db connection from Use Pool, size: " + connectionCurrentlyInUse.size());
           freeConnectionsPool.add(dbConnection);
           System.out.println("Adding db connection into free Pool, size: " + freeConnectionsPool.size());

       }
    }
}
