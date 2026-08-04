package com.elroi.patientservice.dto;

public class UserResponseDto {
    private String email;
    private Boolean isActive;

    public UserResponseDto() {
    }

    public UserResponseDto(String email, Boolean isActive) {
        this.email = email;
        this.isActive = isActive;
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
}
