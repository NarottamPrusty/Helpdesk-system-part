package com.example.helpdesk.repository;

import com.example.helpdesk.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, User> users = new HashMap<>();

    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User findById(int id) {
        return users.get(id);
    }

    public Map<Integer, User> findAll() {
        return users;
    }

    public void deleteById(int id) {
        users.remove(id);
    }
}
