package com.ablive.service;

import com.ablive.entity.User;
import com.ablive.repository.RoleRepository;
import com.ablive.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    //  Introducing constructor injection
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public ResponseEntity createUser(User model) {
        User user = new User();

        if (userRepository.findByEmail(model.getEmail()).isPresent()) {
            System.out.println("The email is already present.");
            return ResponseEntity.badRequest().body("The email is already present. Failed to create the new user");
        } else {
            user.setFirstName(model.getFirstName());
            user.setLastName(model.getLastName());
            user.setMobile(model.getMobile());
            user.setEmail(model.getEmail());
            user.setRoles(model.getRoles());

            User savedUser = userRepository.save(user);
            if (userRepository.findById(savedUser.getId()).isPresent()) {
                return ResponseEntity.ok("User Created Successfully");
            } else {
                return ResponseEntity.unprocessableEntity().body("Failed creating the user as given");
            }
        }
    }

    @Override
    @Transactional
    public ResponseEntity<Object> updateUser(User user, Long id) {
        if (userRepository.findById(id).isPresent()) {
            User newUser = userRepository.findById(id).get();
            for (int i = 0; i < newUser.getRoles().size(); i++) {
                if (roleRepository.findById(newUser.getRoles().get(i).getId()).isPresent()) {
                    roleRepository.deleteById(newUser.getRoles().get(i).getId());
                    if (roleRepository.findById(newUser.getRoles().get(i).getId()).isPresent()) {
                        return ResponseEntity.unprocessableEntity().body("Failed to update the user");
                    }
                }
            }
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setMobile(user.getMobile());
            newUser.setEmail(user.getEmail());
            newUser.setRoles(user.getRoles());

            User savedUser = userRepository.save(newUser);

            if (userRepository.findById(savedUser.getId()).isPresent()) {
                return ResponseEntity.accepted().body("User updated successfully");
            } else {
                return ResponseEntity.unprocessableEntity().body("Failed updating the user specified");
            }
        } else {
            return ResponseEntity.unprocessableEntity().body("Cannot find the user to update");
        }
    }

    @Override
    public ResponseEntity<Object> deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            if (userRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the user");
            } else {
                return ResponseEntity.ok("User Deleted Successfully");
            }
        } else {
            return ResponseEntity.unprocessableEntity().body("User cannot be found");
        }
    }
}