package com.example.obuchen.service.impl;

import com.example.obuchen.entities.Role;
import com.example.obuchen.entities.Status;
import com.example.obuchen.entities.User;
import com.example.obuchen.repo.UserRepo;
import com.example.obuchen.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;


    @Override
    public Optional<User> getById(Long id) {
       return userRepo.findById(id);
    }

    @Override
    public User getByName2(String name) {
        return userRepo.findByName2(name);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
    @Override
    public User addUser(User user) {
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.USER);
        return userRepo.saveAndFlush(user);
    }


    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
