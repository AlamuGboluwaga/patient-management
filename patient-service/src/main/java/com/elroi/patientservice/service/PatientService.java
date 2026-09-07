package com.elroi.patientservice.service;

import com.elroi.patientservice.GlobalErrorHandlling.NotFoundException;
import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.mapper.PatienceMapper;
import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.repository.PatientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
public class PatientService {
    private final PatientRepository patientRepository;

    private final PatienceMapper patienceMapper;

    public PatientService(PatientRepository patientRepository, PatienceMapper patienceMapper) {
        this.patientRepository = patientRepository;
        this.patienceMapper = patienceMapper;
    }

    public PatientRequestDto registerPatient(@Valid @RequestBody PatientRequestDto requestDto) {
        var patient = patienceMapper.toEntity(requestDto);
        Patient savedPatient = patientRepository.save(patient);
        return patienceMapper.toDto(savedPatient);
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        if (patients.isEmpty()) {
            throw new NotFoundException("No patients found");
        }
        return patientRepository.findAll();
    }

    public PatientRequestDto getPatientByEmail(String email) {
        Patient patient = patientRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Patient with email " + email + " not found"));

        return patienceMapper.toDto(patient);

    }

    public String deletePatientByEmail(String email) {
        Patient emailExist = patientRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Patient with email " + email + " not found"));
        patientRepository.delete(emailExist);

        return "Patient with email " + email + " has been deleted successfully";
    }

    public PatientRequestDto updatePatient(String email, PatientRequestDto requestDto) {
        Patient patient = patientRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Patient with email " + email + " not found"));

        patient.setName(requestDto.getName());
        patient.setEmail(requestDto.getEmail());
        patient.setPhone(requestDto.getPhone());
        patient.setAddress(requestDto.getAddress());
        patient.setDateOfBirth(requestDto.getDateOfBirth());
        var updatedpatient = patientRepository.save(patient);
        return patienceMapper.toDto(updatedpatient);
    }
}
