package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl uSI = new UserServiceImpl();
        uSI.createUsersTable();
        uSI.saveUser("Vasya", "Ivanov", (byte) 20);
        uSI.saveUser("Petya", "Kuznetsov", (byte) 30);
        uSI.saveUser("Misha", "Smirnov", (byte) 40);
        uSI.saveUser("Griha", "Borisoff", (byte) 50);
        uSI.removeUserById(1);
        //uSI.cleanUsersTable();

        //uSI.dropUsersTable();
    }
}
