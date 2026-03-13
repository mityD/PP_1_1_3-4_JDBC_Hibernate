package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

//    private Properties uploadingFile() {
//        Properties properties = new Properties();
//        try (InputStream inputStream = new FileInputStream("src/main/resources/databaseQueries.properties")) {
//            properties.load(inputStream);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return properties;
//    }
//
    public void createUsersTable() {
//        try (Connection connection = Util.getInstance();
//             Statement statement = connection.createStatement()) {
//            statement.execute(uploadingFile().getProperty("createTable"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
//
    public void dropUsersTable() {
//        try (Connection connection = Util.getInstance();
//             Statement statement = connection.createStatement()) {
//            statement.execute(uploadingFile().getProperty("dropTable"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
//
    public void saveUser(String name, String lastName, byte age) {
//        try (Connection connection = Util.getInstance();
//             PreparedStatement preparedStatement = connection.prepareStatement(uploadingFile()
//                     .getProperty("saveUser"))) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
//
    public void removeUserById(long id) {
//        try (Connection connection = Util.getInstance();
//             PreparedStatement preparedStatement = connection.prepareStatement(uploadingFile()
//                     .getProperty("removeUserById"))) {
//            preparedStatement.setLong(1, id);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
//
    public List<User> getAllUsers() {
//        List<User> listUsers = new ArrayList<>();
//        try (Connection connection = Util.getInstance();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(uploadingFile().getProperty("allUsers"));
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String lastName = resultSet.getString("lastName");
//                byte age = resultSet.getByte("age");
//                listUsers.add(new User(name, lastName, age));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return listUsers;
        return null;
    }
//
    public void cleanUsersTable() {
//        try (Connection connection = Util.getInstance();
//             Statement statement = connection.createStatement()) {
//            statement.execute(uploadingFile().getProperty("cleanTable"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
