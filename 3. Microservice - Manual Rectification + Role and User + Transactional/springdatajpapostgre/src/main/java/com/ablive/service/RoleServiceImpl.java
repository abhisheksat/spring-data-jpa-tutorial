package com.ablive.service;

import com.ablive.entity.Role;
import com.ablive.entity.User;
import com.ablive.repository.RoleRepository;
import com.ablive.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public ResponseEntity addRole(Role role) {
        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());

        //  To save the transient user objects, we extract all of then under a user and save them
        for (int i = 0; i < role.getUsers().size(); i++) {
            User savedUser = userRepository.save(role.getUsers().get(i));
            System.out.println("Saved----> " + savedUser.toString());
            if (!userRepository.findById(savedUser.getId()).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to create a user");
            }
        }

        //  Throws exception and a part of user data that is saved is rolled back
        if (true) {
            throw new RuntimeException();
        }

        newRole.setUsers(role.getUsers());

        Role savedRole = roleRepository.save(role);
        if (roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully created Role and Users");
        } else {
            return ResponseEntity.unprocessableEntity().body("Failed to create the role");
        }
    }

    @Override
    public ResponseEntity deleteRole(Long id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
            if (roleRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the given record");
            } else {
                return ResponseEntity.ok().body("Record deleted successfully");
            }
        } else {
            return ResponseEntity.unprocessableEntity().body("No records found");
        }
    }

}