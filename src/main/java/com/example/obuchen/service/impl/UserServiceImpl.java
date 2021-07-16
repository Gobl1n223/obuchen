package com.example.obuchen.service.impl;

import com.example.obuchen.entities.User;
import com.example.obuchen.repo.UserRepo;
import com.example.obuchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void delete(Long id) {
        userRepo.delete(userRepo.findById(id));
    }

    @Override
    public void addUser(String name) {

    }
}
