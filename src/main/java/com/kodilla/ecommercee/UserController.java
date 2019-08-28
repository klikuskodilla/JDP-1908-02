package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @GetMapping("/accessDenied")
    public String accessDenied(Long userId){
        return "Access Denied.";
    }

    @GetMapping("/createKey")
    public String createKey(String username,  String password){
        return UUID.randomUUID().toString();
    }
}
