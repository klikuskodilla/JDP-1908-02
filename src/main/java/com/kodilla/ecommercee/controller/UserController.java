package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.entity.GenericEntity;
import com.kodilla.ecommercee.entity.UserEntity;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/create")
    public void createUser(@RequestBody UserDto userDto){
        userRepository.save(userMapper.mapToUser(userDto));
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws Exception {
        if (userRepository.findById(userId).isPresent()){
            return userMapper.mapToUserDto(userRepository.findById(userId).get());
        } else {
            throw new Exception("User not found");
        }
    }

    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userRepository.save(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping("/{userId}/delete")
    public void deleteUser(@PathVariable Long userId) throws Exception {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new Exception("User not found");
        }
    }

    @PutMapping("/ban")
    public void banUser(@RequestParam Long userId) throws Exception {
        if (userRepository.findById(userId).isPresent()){
            UserEntity user = userRepository.findById(userId).get();
            user.setStatus(0);
            userRepository.save(user);
        } else {
            throw new Exception("User not found");
        }
    }

    @PutMapping("/generateKey")
    public void generateKey(@RequestBody UserDto userDto) {
        Optional<UserEntity> user = userRepository.findById(userDto.getId());
        if (user.isPresent()) {
            if (user.get().getLogin().equals(userDto.getLogin())
                    && user.get().getPassword().equals(userDto.getPassword())) {
                Random generator = new Random();
                int userKey;
                do {
                    userKey = generator.nextInt(9000) + 1000;
                } while (!userRepository.existsByUserKey(userKey));
                user.get().setUserKey(userKey);
                userRepository.save(userMapper.mapToUser(userDto));
                resetUserKeyAfterHour(userDto);
            }
        }
    }

    private void resetUserKeyAfterHour(UserDto userDto) {
        TimerTask task = new TimerTask() {
            public void run() {
                if (userRepository.findById(userDto.getId()).isPresent()) {
                    UserEntity user = userRepository.findById(userDto.getId()).get();
                    user.setUserKey(-1);
                    userRepository.save(userMapper.mapToUser(userDto));
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3600000);
    }
}
