package com.example.obuchen.controllers;

import com.example.obuchen.entities.User;
import com.example.obuchen.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@PreAuthorize("hasAuthority('admin:rights')")
public class AdminController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/user/delete")
    public String delete(Model model) {
        model.addAttribute("user", new User());
        return "/account/delete";
    }

    @PostMapping("/user/delete")
    public String delete(@ModelAttribute User user) {
        userService.delete(user.getId());
        return "account/success";
    }

    @GetMapping("/user/all")
    @ResponseBody
    public List<User> getUsers(@ModelAttribute User user) {
        return userService.getAll();
    }

    @GetMapping("/user/search_by_id/{userId}")
    public String test(@PathVariable("userId") Long id, Model model) {

        Optional<User> optional = userService.getById(id);
        model.addAttribute("name", Objects.requireNonNull(optional.orElse(null)).getName());
        return "user";

    }

    @GetMapping("/user/search_by_name/{userName}")
    public String test2(@PathVariable String userName, Model model) {

        User user = userService.getByName2(userName);
        model.addAttribute("userName", user.getName());
        return "user";

    }
}
