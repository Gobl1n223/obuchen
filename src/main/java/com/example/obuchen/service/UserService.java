package com.example.obuchen.service;

import com.example.obuchen.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> getById(Long id);
    User getByName2(String name);
    void delete(Long id);
    User addUser(User user);
    UserDetails loadUserByUsername(String username);
}
