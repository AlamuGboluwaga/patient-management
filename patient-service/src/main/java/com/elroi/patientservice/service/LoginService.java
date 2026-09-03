package com.elroi.patientservice.service;

import com.elroi.patientservice.dto.LoginRequestDto;
import com.elroi.patientservice.repository.LoginRepository;
import com.elroi.patientservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public LoginService(LoginRepository loginRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public boolean isValidLogin(LoginRequestDto request) {

        if (request == null) {
            throw new IllegalArgumentException("Login request cannot be null");
        }
        var usersDetails = userRepository.findByEmail(request.getEmail());
        if (usersDetails.isEmpty()) {
            log.warn("User not found for email: {}", request.getEmail());
            return false;
        }

        var encodedPassword = usersDetails.get().getPassword();


        var match = passwordEncoder.matches(request.getPassword(), encodedPassword);
        if (!match) {
            log.warn("Password mismatch for email: {}", request.getEmail());
            return false;
        } else {
            log.info("Login successful for email: {}", request.getEmail());
            return true;
        }

    }
}
