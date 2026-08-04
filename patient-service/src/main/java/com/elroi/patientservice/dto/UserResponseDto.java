package com.elroi.patientservice.dto;

import java.util.UUID;

public class UserResponseDto {
    private UUID id;
    private String email;
    private Boolean isActive;
    private String role;


    public UserResponseDto() {
    }

    public UserResponseDto(UUID id, String email, Boolean isActive, String role) {
        this.id = id;
        this.email = email;
        this.isActive = isActive;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
