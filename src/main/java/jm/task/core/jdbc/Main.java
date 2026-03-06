package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Katy", "Krokk", (byte) 13);
        userService.saveUser("Valera", "Popov", (byte) 11);
        userService.saveUser("Sveta", "Gazova", (byte) 33);
        userService.saveUser("Pavlik", "Morozov", (byte) 23);

//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();;

    }
}
