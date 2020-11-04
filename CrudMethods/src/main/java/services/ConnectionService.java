package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private static final String URL = "jdbc:sqlite:main.db";

    private static final Connection connect = connect();

    public static Connection connect() {
        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL);
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
            return connection;
        } catch (SQLException ex) {
            System.err.println("Соединение не установлено");
            ex.printStackTrace();
            return null;
        }
    }

    public static Connection getConnect() {
        return connect;
    }
}
