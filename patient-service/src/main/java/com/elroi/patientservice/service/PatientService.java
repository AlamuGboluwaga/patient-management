package com.elroi.patientservice.service;

import com.elroi.patientservice.GlobalErrorHandlling.NotFoundException;
import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        if (patients.isEmpty()) {
            throw new NotFoundException("No patients found");
        }
        return patientRepository.findAll();

    }

}
