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
@Table(name = "login_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "Email is required")
    @Column(name = "email")
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "status")
    @NotBlank(message = "Status is required")
    private String status;
    private LocalDateTime loggedInAt;

    @PrePersist
    public void loggedInAt() {
        loggedInAt = LocalDateTime.now();
    }
}

