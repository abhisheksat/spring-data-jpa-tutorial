package com.ablive.controller;

import com.ablive.entity.Role;
import com.ablive.entity.User;
import com.ablive.model.RoleModel;
import com.ablive.model.UserModel;
import com.ablive.repository.UserRepository;
import com.ablive.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    //  Introducing constructor injection
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //  POST operation to create a new user
    @PostMapping(value = "/user/create")
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value = "/user/details/{id}")
    public UserModel getUser(@PathVariable Long id) {
        if (userRepository.findById(id).isPresent()) {
            User user = userRepository.findById(id).get();
            UserModel userModel = new UserModel();
            userModel.setFirstName(user.getFirstName());
            userModel.setLastName(user.getLastName());
            userModel.setEmail(user.getEmail());
            userModel.setMobile(user.getMobile());
            userModel.setRoles(getRoleList(user));
            return userModel;
        } else {
            return null;
        }
    }

    private List<RoleModel> getRoleList(User user) {
        List<RoleModel> roleList = new ArrayList<RoleModel>();
        for (Role role : user.getRoles()) {
            RoleModel roleModel = new RoleModel();
            roleModel.setName(role.getName());
            roleModel.setDescription(role.getDescription());
            roleList.add(roleModel);
        }
        return roleList;
    }

    @GetMapping(value = "/users/all")
    public List<UserModel> getUsers() {
        List<UserModel> userModelList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            UserModel userModel = new UserModel();
            userModel.setFirstName(user.getFirstName());
            userModel.setLastName(user.getLastName());
            userModel.setEmail(user.getEmail());
            userModel.setMobile(user.getMobile());
            userModel.setRoles(getRoleList(user));
            userModelList.add(userModel);
        }
        return userModelList;
    }

    @PutMapping(value = "/user/update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/user/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}