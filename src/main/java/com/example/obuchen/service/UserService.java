package com.example.obuchen.service;

import com.example.obuchen.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getById(Long id);
    User getByName2(String name);
    void delete(Long id);
    User addUser(User user);
    List<User> getAll();
    Optional<User> getByEmail(String email);

}
