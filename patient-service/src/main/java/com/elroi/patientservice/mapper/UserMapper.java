package com.elroi.patientservice.mapper;

import com.elroi.patientservice.dto.UserRequestDto;
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
}
