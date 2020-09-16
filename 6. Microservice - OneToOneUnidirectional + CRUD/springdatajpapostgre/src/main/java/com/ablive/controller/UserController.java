package com.ablive.controller;

import com.ablive.entity.User;
import com.ablive.model.UserModel;
import com.ablive.repository.UserRepository;
import com.ablive.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    //  Introducing constructor injection
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //  POST operation to create a new user
    @PostMapping(value = "/user/create")
    public ResponseEntity createUser(@RequestBody UserModel model) {
        return userService.createUser(model);
    }

    @GetMapping(value = "/user/details/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping(value = "/users/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}