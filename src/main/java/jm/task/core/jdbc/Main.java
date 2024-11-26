package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.cleanUsersTable();

        userService.saveUser("Michael", "Schumacher", (byte) 50);
        userService.saveUser("Sebastian", "Vettel", (byte) 37);

        System.out.println("Все пользователи :");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        userService.createUsersTable();
        userService.dropUsersTable();
    }
}
