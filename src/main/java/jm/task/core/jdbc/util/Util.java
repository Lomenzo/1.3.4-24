package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соединения с БД

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ded", "root", "1Dothisf");
            connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
