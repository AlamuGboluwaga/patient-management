package com.elroi.patientservice.mapper;

import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.dto.PatientResponseDto;
import com.elroi.patientservice.model.Patient;


public class PatientMapper {


    public Patient toEntity(PatientRequestDto patientRequestDto) {

        return new Patient(
                null,
                patientRequestDto.getName(),
                patientRequestDto.getEmail(),
                patientRequestDto.getPhone(),
                patientRequestDto.getAddress(),
                patientRequestDto.getDateOfBirth(),
                null
        );
    }

    public PatientResponseDto toDto(Patient patient) {
        return new PatientResponseDto(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getAddress(),
                patient.getDateOfBirth(),
                patient.getCreatedAt()
        );
    }

}