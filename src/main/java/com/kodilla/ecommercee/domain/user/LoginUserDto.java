package com.kodilla.ecommercee.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUserDto {
    private int status;
    private String login;
    private String password;
}
