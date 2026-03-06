package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Connection instance = null;
    private final static String DB_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private final static String USER = "postgres";
    private final static String PASSWORD = "root";

    private Util() { }

    public synchronized static Connection getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null || instance.isClosed()) {
            instance = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//            System.out.println("Соединение установлено");
        }
        return instance;
    }
}
