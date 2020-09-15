package com.ablive.service;

import com.ablive.model.UserModel;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity createUser(UserModel model);
}