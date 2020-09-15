package com.ablive.service;

import com.ablive.entity.User;
import com.ablive.model.UserModel;
import com.ablive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity createUser(UserModel model) {
        User user = new User();

        if (userRepository.findByEmail(model.getEmail()).isPresent()) {
            System.out.println("The email is already present.");
            return ResponseEntity.badRequest().body("The email is already present. Failed to create the new user");
        } else {
            user.setFirstName(model.getFirstName());
            user.setLastName(model.getLastName());
            user.setMobile(model.getMobile());
            user.setEmail(model.getEmail());
            userRepository.save(user);
            return ResponseEntity.ok("New user created successfully.");
        }
    }

}