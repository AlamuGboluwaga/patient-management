package com.elroi.patientservice.Controllers;

import com.elroi.patientservice.model.User;
import com.elroi.patientservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/all")
    @Operation(summary = "Get all Users", description = "Retrieve a list of all users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/api/users/create")
    @Operation(summary = "Create a new User", description = "Create a new user with the provided details")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(userService.createUser(user));
    }
}
