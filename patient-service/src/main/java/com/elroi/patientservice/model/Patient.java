package com.elroi.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;
    @NotBlank(message = "Phone is required")
    @Column(name = "phone")
    private String phone;
    @NotBlank(message = "Address is required")
    @Column(name = "address")
    private String address;
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist

    public void OnCreate() {
        createdAt = LocalDateTime.now();
    }

    public Patient() {
    }

    public Patient(UUID id, String name, String email, String phone, String address, LocalDate dateOfBirth, LocalDateTime createdAt) {
        Id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
