package com.elroi.patientservice.service;

import com.elroi.patientservice.GlobalErrorHandlling.NotFoundException;
import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.dto.PatientResponseDto;
import com.elroi.patientservice.mapper.PatientMapper;
import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.repository.PatientRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PatientService {
    private static final Logger log = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponseDto registerPatient(@Valid @RequestBody PatientRequestDto requestDto) {
        PatientMapper patientMapper = new PatientMapper();
        Patient patient = patientMapper.toEntity(requestDto);
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
        System.out.println("found: " + patient.getId());
        PatientMapper patientMapper = new PatientMapper();
        return patientMapper.toDto(patient);

    }

    public String deletePatientByEmail(String email) {

        Patient patient = patientRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Patient with email " + email + " not found"));
        patientRepository.delete(patient);
        PatientMapper patientMapper = new PatientMapper();
        return "Patient with email " + email + " has been deleted successfully";
    }
}
