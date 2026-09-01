package com.elroi.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "login")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "Email is required")
    @Column(name = "email", unique = true)
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password is required")
    @Column(name = "password")
    private String password;
    @Column(name = "logged_in_at")
    private LocalDateTime loggedInAt;

    @PrePersist
    public void prePersist() {
        loggedInAt = LocalDateTime.now();
    }
}
