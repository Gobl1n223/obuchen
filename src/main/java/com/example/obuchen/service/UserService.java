package com.example.obuchen.service;

import com.example.obuchen.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getById(Long id);
    void delete(Long id);
    User addUser(User user);

}
