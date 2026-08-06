package com.elroi.patientservice.dto;

import java.util.UUID;

public class UserResponseDto {
    private UUID id;
    private String email;
    private String role;
    private Boolean isActive;

    public UserResponseDto() {
    }

    public UserResponseDto(UUID id, String email, String role, Boolean isActive) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
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
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
