package com.example.demo.api.controller;

import com.example.demo.api.dto.CreateUserDto;
import com.example.demo.api.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    public UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public User getUserById(@RequestParam Integer id){
        Optional<User> user = userService.getUserById(id);
        return user.orElse(null);
    }
    @PostMapping
    public List<User> createUser(@RequestBody CreateUserDto createUserDto){
        Optional<List<User>> userList = Optional.ofNullable(userService.createUser(createUserDto));
        return userList.orElse(null);
    }
}
