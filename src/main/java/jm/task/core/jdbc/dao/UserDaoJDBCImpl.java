package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private String createTable = "CREATE TABLE IF NOT EXISTS USERS (id SERIAL PRIMARY KEY, name VARCHAR(40), " +
            "lastName VARCHAR(30), age INT)";
    private String dropTable = "Drop TABLE IF EXISTS USERS";
    private String saveUser = "INSERT INTO USERS(name, lastName, age) VALUES (?, ?, ?)";
    private String removeUserById = "DELETE FROM USERS WHERE id = ?";
    private String allUsers = "SELECT * FROM USERS";
    private String cleanTable = "TRUNCATE TABLE USERS";

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Connection connection = Util.getInstance();
             Statement statement = connection.createStatement()) {
            statement.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(dropTable)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(saveUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(removeUserById)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> listUsers = new ArrayList<>();
        try (Connection connection = Util.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(allUsers)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                listUsers.add(new User(name, lastName, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getInstance();
             PreparedStatement preparedStatement = connection.prepareStatement(cleanTable)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
