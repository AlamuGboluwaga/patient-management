package com.elroi.patientservice.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressRequestDto {
    @NotBlank(message = "Country is required")
    private String country;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "Zip Code is required")
    private String zipCode;
}