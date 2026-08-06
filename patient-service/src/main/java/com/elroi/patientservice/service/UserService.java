package com.elroi.patientservice.service;

import com.elroi.patientservice.dto.UserRequestDto;
import com.elroi.patientservice.dto.UserResponseDto;
import com.elroi.patientservice.mapper.UserMapper;
import com.elroi.patientservice.model.User;
import com.elroi.patientservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        UserMapper mapper = new UserMapper();
//        mapper.toDto();


//        return users.stream().map(user -> new UserResponseDto(
//                user.getId(),
//                user.getEmail(),
//                user.getIsActive(),
//                user.getRole()
//
//        )).toList();

        return null;

    }

    public UserResponseDto createUser(UserRequestDto requestDto) {
        var mapper = new UserMapper();
        var toEntity = mapper.toEntity(requestDto);
        User user = userRepository.save(toEntity);
        var toDto = mapper.toDto(user);
        return null;
    }
}
