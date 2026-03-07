package jm.task.core.jdbc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static Connection instance = null;

    private Util() {
    }

    public synchronized static Connection getInstance() throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(inputStream);
            if (instance == null || instance.isClosed()) {
                instance = DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("user"), properties.getProperty("password"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }


}
