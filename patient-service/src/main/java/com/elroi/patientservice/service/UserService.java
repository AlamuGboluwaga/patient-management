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

        return users.stream().map(user -> new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getActive(),
                user.getRole()

        )).toList();

    }

    public UserResponseDto createUser(UserRequestDto requestDto) {

        var user = new UserMapper();
        var newUser = user.toEntity(requestDto);
        userRepository.save(newUser);

        return null;
    }
}
