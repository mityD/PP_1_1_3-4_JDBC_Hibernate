package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД


    private final static String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private final static String USER = "postgres";
    private final static String PASSWORD = "root";

    public static Connection getPostgresConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection =  DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Соединение установлено");
            return connection;
//            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Соединение не установлено " + e);
        }
        System.out.println("Соединение не установлено ");
        return null;
    }
}
