package com.elroi.patientservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class PatientRequestDto {

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name = "email", unique = true)
    private String email;
    @NotBlank(message = "Phone is required")
    @Column(name = "phone", unique = true)
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    private String phone;
    @NotBlank(message = "Address is required")
    @Column(name = "address")
    private String address;
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    public PatientRequestDto() {
    }

    public PatientRequestDto(String name, String email, String phone, String address, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
