package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Katy", "Krokk", (byte) 13);
        System.out.println("User с именем — Katy добавлен в базу данных");
        userService.saveUser("Valera", "Popov", (byte) 11);
        System.out.println("User с именем — Valera добавлен в базу данных");
        userService.saveUser("Sveta", "Gazova", (byte) 33);
        System.out.println("User с именем — Sveta добавлен в базу данных");
        userService.saveUser("Pavlik", "Morozov", (byte) 23);
        System.out.println("User с именем — Pavlik добавлен в базу данных");

        List<User> users =  userService.getAllUsers();
        users.forEach(user -> System.out.println(user.toString()));
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
