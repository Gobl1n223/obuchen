package com.example.obuchen.controllers;

import com.example.obuchen.entities.User;

import com.example.obuchen.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@Controller
public class GreetingController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "Artem" );
        return "greeting";
    }

    @GetMapping("/searchUserById/{userId}")
    public String test(@PathVariable("userId") Long id, Model model) {

        Optional<User> optional = userService.getById(id);
        model.addAttribute("name", Objects.requireNonNull(optional.orElse(null)).getName());
        return "user";

    }

    @GetMapping("/searchUserByName/{userName}")
    public String test2(@PathVariable("userName") String name, Model model) {

        User user = userService.getByName2(name);
        model.addAttribute("name", user.getName());
        return "user";

    }



    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

}