package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.user.UserDto;
import com.kodilla.ecommercee.entity.UserEntity;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "users", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("create")
    public void createUser(@RequestBody UserDto userDto){
        userService.saveUser(userMapper.mapToUser(userDto));
    }

    @GetMapping("")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @GetMapping("{userId}")
    public UserDto getUser(@PathVariable Long userId) throws Exception {
        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(Exception::new));
    }

    @PutMapping("update")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping("{userId}/delete")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("{userId}/ban")
    public void banUser(@PathVariable Long userId) {
        userService.banUser(userId);
    }

    @PutMapping("login")
    public UserDto attemptLogin(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.attemptLogin(userMapper.mapToUser(userDto)));
    }
}
