package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.entity.GenericEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
public class UserController {
    @PostMapping("/createUser")
    public void createUser(@RequestBody GenericEntity userDto){
        new GenericEntity();
    }

    @GetMapping("/{id}")
    public GenericEntity getUser(@PathVariable Long id){
        return new GenericEntity();
    }

    @PutMapping("/update")
    public GenericEntity updateUser(@RequestBody GenericEntity userDto){
       return userDto;
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUser(@PathVariable Long id){
    }
}
