package com.example.helpdesk.service;

import com.example.helpdesk.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final HashMap<Integer, User> userStorage = new HashMap<>();

    // Add a user
    public User addUser(User user) {
        if (userStorage.values().stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new IllegalArgumentException("Email already exists");
        }
        userStorage.put(user.getId(), user);
        return user;
    }

    // Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(userStorage.values());
    }

    // Get user by ID
    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userStorage.get(id));
    }

    // Delete user by ID
    public boolean deleteUserById(int id) {
        if (userStorage.containsKey(id)) {
            userStorage.remove(id);
            return true;
        }
        return false;
    }
}
