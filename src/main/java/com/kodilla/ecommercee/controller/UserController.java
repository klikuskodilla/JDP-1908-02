package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.entity.GenericEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/createUser")
    public GenericEntity createUser(){
        return new GenericEntity();
    }

    @GetMapping("/{id}")
    public GenericEntity getUser(Long id){
        return new GenericEntity();
    }

    @PutMapping("/{id}/update")
    public GenericEntity updateUser(Long id){
        return new GenericEntity();
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUser(Long id){
    }
}
