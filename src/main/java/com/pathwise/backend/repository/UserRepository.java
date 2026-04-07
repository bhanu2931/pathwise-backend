package com.pathwise.backend.repository;

import com.pathwise.backend.model.User;
import java.util.*;

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {

        if (user.getId() == null) {
            user.setId((long) (users.size() + 1));
        }

        users.add(user);
        return user;
    }

    public User findByEmail(String email) {

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }
}