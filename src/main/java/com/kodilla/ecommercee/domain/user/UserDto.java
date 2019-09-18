package com.kodilla.ecommercee.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private int status;
    private String userKey;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postCode;
    private String phone;
    private String mail;
}
