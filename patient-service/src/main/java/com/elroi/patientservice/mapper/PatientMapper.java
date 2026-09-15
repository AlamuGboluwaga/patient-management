package com.elroi.patientservice.mapper;

import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.dto.PatientResponseDto;
import com.elroi.patientservice.dto.AddressRequestDto;
import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    // Ignored on creation since ID is auto-generated and timestamps are DB-managed
    Patient toEntity(PatientRequestDto patientRequestDto);

    PatientResponseDto toDto(Patient entity);

    // Map AddressRequestDto to Address entity so MapStruct can convert nested address DTOs
    @Mapping(target = "id", ignore = true)
    Address toAddress(AddressRequestDto addressRequestDto);
}
