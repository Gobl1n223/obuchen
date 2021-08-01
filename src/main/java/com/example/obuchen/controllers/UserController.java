package com.example.obuchen.controllers;

import com.example.obuchen.entities.User;
import com.example.obuchen.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/sing_up")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "auth/new";
    }

    @PostMapping("/sing_up")
    public String addUser(@ModelAttribute User user,
                          Model model) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        userService.addUser(user);
        model.addAttribute("user", user);

        return "account/success";
    }


    @GetMapping("/login")
    public String login() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
        return "auth/login";


    }

    @GetMapping("account/my")
    @PreAuthorize("hasAuthority('user:rights')")
    public String myAccount() {

        System.out.println("account");
        System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());

            return "account/my";


    }

}
