package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToUser(UserDto userDto) {
        return new UserEntity(userDto.getId(), userDto.getUsername(), userDto.getStatus(), userDto.getUserKey(),
                userDto.getLogin(), userDto.getPassword(), userDto.getCredentialEntity());
    }

    public UserDto mapToUserDto(UserEntity userEntity) {
        return new UserDto(userEntity.getId(), userEntity.getUsername(), userEntity.getStatus(), userEntity.getUserKey(),
                userEntity.getLogin(), userEntity.getPassword(), userEntity.getCredentialEntity());
    }
}
