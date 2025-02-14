package com.company;

import java.util.ArrayList;
import java.util.List;

class UserRepository {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}