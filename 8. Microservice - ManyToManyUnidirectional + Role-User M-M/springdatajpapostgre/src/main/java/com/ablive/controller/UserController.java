package com.ablive.controller;

import com.ablive.entity.User;
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
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value = "/user/details/{id}")
    public User getUser(@PathVariable Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/users/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping(value = "/user/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}