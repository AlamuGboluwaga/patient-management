package com.elroi.patientservice.service;

import com.elroi.patientservice.dto.LoginRequestDto;
import com.elroi.patientservice.repository.LoginHistoryRepository;
import com.elroi.patientservice.repository.UserRepository;
import com.elroi.patientservice.trail.LoginHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {
    private final LoginHistoryRepository loginHistoryRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public LoginService(LoginHistoryRepository loginHistoryRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.loginHistoryRepository = loginHistoryRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }

    public boolean isValidLogin(LoginRequestDto request) {
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setEmail(request.getEmail());

        var user = userRepository.findByEmail(request.getEmail());

        if (user.isEmpty()) {
            log.warn("User not found for email: {}", request.getEmail());

            loginHistory.setStatus("FAILED");
            loginHistoryRepository.save(loginHistory);

            return false;
        }

        var encodedPassword = user.get().getPassword();

        boolean match = passwordEncoder.matches(
                request.getPassword(),
                encodedPassword
        );

        if (!match) {
            log.warn("Password mismatch for email: {}", request.getEmail());

            loginHistory.setStatus("FAILED");
            loginHistoryRepository.save(loginHistory);

            return false;
        }

        loginHistory.setStatus("SUCCESS");
        loginHistoryRepository.save(loginHistory);

        log.info("Login successful for email: {}", request.getEmail());

        return true;
    }
}
