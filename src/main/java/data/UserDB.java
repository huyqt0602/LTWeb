package data;

import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB {

    private static List<User> users = new ArrayList<>();

    public static void insert(User user) {
        users.add(user);
        System.out.println("User saved successfully!");
    }

    public static List<User> getUsers() {
        return users;
    }
}
