package com.ablive.service;

import com.ablive.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity createUser(User user);
    ResponseEntity<Object> updateUser(User user, Long id);
    ResponseEntity<Object> deleteUser(Long id);
}