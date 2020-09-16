package com.ablive.service;

import com.ablive.entity.Role;
import com.ablive.repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    //  Introducing constructor injection
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity addRole(Role role) {
        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());

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

    public ResponseEntity<Object> updateRole(Long id, Role role) {
        if (roleRepository.findById(id).isPresent()) {
            Role newRole = roleRepository.findById(id).get();
            newRole.setName(role.getName());
            newRole.setDescription(role.getDescription());
            Role savedRole = roleRepository.save(newRole);
            if (roleRepository.findById(id).isPresent()) {
                return ResponseEntity.accepted().body("Role saved successfully");
            } else {
                return ResponseEntity.badRequest().body("Failed to update the role");
            }
        } else {
            return ResponseEntity.unprocessableEntity().body("Specifiec role not found");
        }
    }
}