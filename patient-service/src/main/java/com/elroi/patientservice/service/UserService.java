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
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> userRes = userRepository.findAll();


        return userRes.stream().map(user -> new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getRole(),
                user.getIsActive()

        )).toList();

    }

    public UserResponseDto createUser(UserRequestDto requestDto) {
        var toEntity = userMapper.toEntity(requestDto);
        User user = userRepository.save(toEntity);
        var toDto = userMapper.toDto(user);
        return null;
    }
}
