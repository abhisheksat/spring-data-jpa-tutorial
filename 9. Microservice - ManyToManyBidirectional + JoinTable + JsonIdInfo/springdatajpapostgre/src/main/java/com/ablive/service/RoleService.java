package com.ablive.service;

import com.ablive.entity.Role;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity addRole(Role role);
    ResponseEntity deleteRole(Long id);
    ResponseEntity<Object> updateRole(Long id, Role role);
}