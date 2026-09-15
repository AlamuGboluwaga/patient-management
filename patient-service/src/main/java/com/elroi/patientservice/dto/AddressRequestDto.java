package com.elroi.patientservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;
n@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {
    @NotBlank(message = "Country is required")
    @Schema(example = "Nigeria")
    private String country;
    @NotBlank(message = "State is required")
    @Schema(example = "Lagos")
    private String state;
    @NotBlank(message = "City is required")
    @Schema(example = "Ikeja")
    private String city;
    @NotBlank(message = "Street is required")
    @Schema(example = "12 Main St")
    private String street;
    @NotBlank(message = "Zip Code is required")
    @Schema(example = "100001")
    private String zipCode;
}