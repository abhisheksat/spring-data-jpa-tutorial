package com.ablive.controller;

import com.ablive.model.UserModel;
import com.ablive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //  POST operation to create a new user
    @PostMapping(value = "/user/create")
    public ResponseEntity createUser(@RequestBody UserModel model) {
        return userService.createUser(model);
    }

}