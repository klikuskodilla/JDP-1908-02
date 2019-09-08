package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.entity.CredentialEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private int status;
    private int userKey;
    private String login;
    private String password;
    private CredentialEntity credentialEntity;
}
