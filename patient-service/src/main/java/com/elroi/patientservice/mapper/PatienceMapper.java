package com.elroi.patientservice.mapper;

import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatienceMapper {
    @Mapping(target = "id", ignore = true)
        //Ignored on creation since ID is auto-generated
    Patient toEntity(PatientRequestDto patientRequestDto);

    PatientRequestDto toDto(Patient entity);
}
