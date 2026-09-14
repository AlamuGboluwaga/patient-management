package com.elroi.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "login")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "Email is required")
    @Column(name = "email", unique = true)
    @Email(message = "Email or password is invalid")
    private String email;
    @NotBlank(message = "Email or password is invalid")
    @Column(name = "password")
    private String password;
    @Column(name = "logged_in_at")
    private LocalDateTime loggedInAt;

    @PrePersist
    public void prePersist() {
        loggedInAt = LocalDateTime.now();
    }
}
