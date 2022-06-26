package test.jdbc_pool.connection;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import test.jdbc_pool.utils.ConnectionPoolConst;

import javax.sql.DataSource;

public class ConnectionPool implements ConnectionPoolConst {

    private static GenericObjectPool gPool = null;

    @SuppressWarnings("unused")
    public DataSource setUpPool() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        // Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
        gPool = new GenericObjectPool();
        gPool.setMaxActive(5);

        // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
        ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASSWORD);

        // Creates a Pool-able ConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
        PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
        return new PoolingDataSource(gPool);
    }

    public GenericObjectPool getConnectionPool() {
        return gPool;
    }

    // This Method Is Used To Print The Connection Pool Status
    public void printDbStatus() {
        System.out.print("Connection Pool Status - ");
        System.out.println("Max: " + getConnectionPool().getMaxActive() + " | Active: " + getConnectionPool().getNumActive() + " | Idle: " + getConnectionPool().getNumIdle());
    }

}