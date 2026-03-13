package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static SessionFactory sessionFactory = getSessionFactory();

    public synchronized static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/postgres");
            configuration.setProperty("hibernate.connection.username", "postgres");
            configuration.setProperty("hibernate.connection.password", "root");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("соединение установлено");
        }
        return sessionFactory;
    }
//    public synchronized static Connection getInstance() throws ClassNotFoundException, SQLException {
//        Properties properties = new Properties();
//        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
//            properties.load(inputStream);
//            if (instance == null || instance.isClosed()) {
//                instance = DriverManager.getConnection(properties.getProperty("db.url"),
//                        properties.getProperty("user"), properties.getProperty("password"));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return instance;
//    }


}
