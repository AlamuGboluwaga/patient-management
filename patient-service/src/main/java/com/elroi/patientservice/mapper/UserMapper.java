package com.elroi.patientservice.mapper;

import com.elroi.patientservice.dto.UserRequestDto;
import com.elroi.patientservice.dto.UserResponseDto;
import com.elroi.patientservice.model.User;

public class UserMapper {
    public User toEntity(UserRequestDto userRequestDto) {

        return new User(
                null,
                userRequestDto.getEmail(),
                userRequestDto.getPassword(),
                "USER",
                true
        );
    }


    public UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                user.getIsActive()
        );
    }

}
