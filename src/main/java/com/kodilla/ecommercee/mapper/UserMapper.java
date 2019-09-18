package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.user.UserDto;
import com.kodilla.ecommercee.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserEntity mapToUser(UserDto userDto) {
        return new UserEntity(userDto.getId(),
                userDto.getUsername(),
                userDto.getStatus(),
                userDto.getUserKey(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getStreet(),
                userDto.getCity(),
                userDto.getPostCode(),
                userDto.getPhone(),
                userDto.getMail()
        );
    }

    public UserDto mapToUserDto(UserEntity userEntity) {
        return new UserDto(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getStatus(),
                userEntity.getUserKey(),
                userEntity.getLogin(),
                userEntity.getPassword(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getStreet(),
                userEntity.getCity(),
                userEntity.getPostCode(),
                userEntity.getPhone(),
                userEntity.getMail()
        );
    }

    public List<UserDto> mapToUserDtoList(List<UserEntity> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (UserEntity user : users) {
            usersDto.add(mapToUserDto(user));
        }
        return usersDto;
    }
}
