package com.ablive.controller;

import com.ablive.entity.Role;
import com.ablive.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(value = "/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @DeleteMapping(value = "/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }

}