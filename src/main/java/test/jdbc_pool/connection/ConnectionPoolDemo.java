package test.jdbc_pool.connection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPoolDemo {

    public static void main(String[] args) {

        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ConnectionPool connectionPool = new ConnectionPool();

        try {
            DataSource dataSource = connectionPool.setUpPool();

            connectionPool.printDbStatus();

            // Performing Database Operation!
            connection = dataSource.getConnection();

            connectionPool.printDbStatus();

            preparedStatement = connection.prepareStatement("SELECT * FROM user");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " : " + resultSet.getString("username"));
            }

            connection.close();

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        connectionPool.printDbStatus();

    }

}