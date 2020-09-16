package com.ablive.controller;

import com.ablive.entity.Role;
import com.ablive.repository.RoleRepository;
import com.ablive.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    private RoleService roleService;
    private RoleRepository roleRepository;

    //  Introducing constructor injection
    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @PostMapping(value = "/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @DeleteMapping(value = "/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

    @GetMapping(value = "/role/details/{id}")
    public Role getRole(@PathVariable Long id) {
        return roleRepository.findById(id).get();
    }

    @GetMapping(value = "/roles/all")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

}