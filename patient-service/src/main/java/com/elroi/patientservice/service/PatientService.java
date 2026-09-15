package com.elroi.patientservice.service;

import com.elroi.patientservice.GlobalErrorHandlling.NotFoundException;
import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.dto.PatientResponseDto;
import com.elroi.patientservice.mapper.PatientMapper;
import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Slf4j
@Service
public class PatientService {
    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, @Qualifier("patientMapperImpl") PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public PatientResponseDto registerPatient(PatientRequestDto requestDto) {
        var patient = patientMapper.toEntity(requestDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDto(savedPatient);

    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        if (patients.isEmpty()) {
            throw new NotFoundException("No patients found");
        }
        return patientRepository.findAll();
    }

    public PatientResponseDto getPatientByEmail(String email) {
        Patient patient = patientRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Patient with email " + email + " not found"));

        return patientMapper.toDto(patient);

    }

    public String deletePatientByEmail(String email) {
        Patient emailExist = patientRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Patient with email " + email + " not found"));
        patientRepository.delete(emailExist);

        return "Patient with email " + email + " has been deleted successfully";
    }

    public PatientResponseDto updatePatient(String email, PatientRequestDto requestDto) {
        Patient patient = patientRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Patient with email " + email + " not found"));

        patient.setName(requestDto.getName());
        patient.setEmail(requestDto.getEmail());
        patient.setPhone(requestDto.getPhone());
        patient.setAddress(patientMapper.toAddress(requestDto.getAddress()));
        patient.setDateOfBirth(requestDto.getDateOfBirth());
        var updatedpatient = patientRepository.save(patient);
        return patientMapper.toDto(updatedpatient);
    }
}
