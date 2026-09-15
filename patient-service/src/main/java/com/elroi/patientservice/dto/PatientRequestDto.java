package com.elroi.patientservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PatientRequestDto {
    @NotBlank(message = "Name is required")
    @Schema(example = "John Doe")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Schema(example = "john.doe@example.com")
    private String email;
    @NotBlank(message = "Phone is required")

    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    @Schema(example = "01234567890")
    private String phone;
    @NotNull(message = "Address is required")
    @Schema(description = "Postal address", implementation = AddressRequestDto.class)
    private AddressRequestDto address;
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @Schema(example = "1990-05-20")
    private LocalDate dateOfBirth;

}
