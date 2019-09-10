package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.user.UserDto;
import com.kodilla.ecommercee.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserEntity mapToUser(UserDto userDto) {
        return new UserEntity();
    }

    public UserDto mapToUserDto(UserEntity userEntity) {
        return new UserDto();
    }

    public List<UserDto> mapToUserDtoList(List<UserEntity> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (UserEntity user : users) {
            usersDto.add(mapToUserDto(user));
        }
        return usersDto;
    }
}
