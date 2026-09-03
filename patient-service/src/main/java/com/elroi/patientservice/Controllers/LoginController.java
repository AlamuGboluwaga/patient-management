package com.elroi.patientservice.Controllers;

import com.elroi.patientservice.dto.LoginRequestDto;
import com.elroi.patientservice.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "Login Controller", description = "Handles user login requests")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/api/login/")
    @Operation(summary = "Login endpoint", description = "Validates user login credentials")
    public ResponseEntity<Boolean> login(@Valid @RequestBody LoginRequestDto request) {

        boolean isValid = loginService.isValidLogin(request);
        if (!isValid) {
            log.warn("Login failed for email: {}", request.getEmail());
            return ResponseEntity.ok(false);
        } else {

            return ResponseEntity.ok(true);
        }


    }
}



