package com.example.obuchen.controllers;

import com.example.obuchen.entities.User;
import com.example.obuchen.repo.UserRepo;
import com.example.obuchen.service.UserService;
import com.example.obuchen.service.impl.NoteServiceImpl;
import com.example.obuchen.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
public class GreetingController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "Artem" );
        return "greeting";
    }

    @GetMapping("/searchUser/{userId}")
    public String test(@PathVariable("userId") Long id, Model model) {

        Optional<User> optional = userService.getById(id);
        model.addAttribute("user", Objects.requireNonNull(optional.orElse(null)).getName());
        return "user";

    }

}