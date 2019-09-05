package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.entity.GenericEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/createUser")
    public void createUser(@RequestBody GenericEntity userDto){
    }

    @GetMapping("/{id}")
    public GenericEntity getUser(@RequestParam Long userId){
        return new GenericEntity();
    }

    @PutMapping("/{id}/update")
    public GenericEntity updateUser(@RequestBody GenericEntity userDto){
       return userDto;
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUser(@RequestParam Long userId){
    }
}
