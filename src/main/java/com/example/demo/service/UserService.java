package com.example.demo.service;

import com.example.demo.api.dto.CreateUserDto;
import com.example.demo.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> userList;
    public  UserService(){
        userList = new ArrayList<>();
        User user1 = new User(1, "Phùng Hữu Đạt",23, "phungdat0902@gmail.com");
        User user2 = new User(2, "Phùng Hữu Nam",23, "phungdat0902@gmail.com");
        User user3 = new User(3, "Phùng Hữu Trung",23, "phungdat0902@gmail.com");
        User user4 = new User(4, "Phùng Hữu Sơn",23, "phungdat0902@gmail.com");
        User user5 = new User(5, "Phùng Hữu Tùng",23, "phungdat0902@gmail.com");
        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
    public Optional<User> getUserById(Integer id) {
       return userList.stream()
               .filter(user -> user.id() == id)
               .findFirst();
    }
    public List<User> createUser(CreateUserDto createUserDto){
        User newUser = new User(createUserDto.id(), createUserDto.name(), createUserDto.age(), createUserDto.email());
        userList.add(newUser);
        return userList;
    }
}
