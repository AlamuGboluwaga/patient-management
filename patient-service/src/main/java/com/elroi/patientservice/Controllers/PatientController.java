package com.elroi.patientservice.Controllers;

import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String test() {
        return "It is settled in Jesus Name";
    }


    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatient() {

        List<Patient> patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            throw new RuntimeException("No patients found");
        }
        return ResponseEntity.ok().body(patients);
    }
}
