package com.elroi.patientservice.Controllers;

import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.dto.PatientResponseDto;
import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Patient APIs", description = "Controller for managing patients")

public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/test")
    @Operation(summary = "Test Endpoint", description = "Returns a test message to verify the service is running.")
    public String test() {
        return "It is settled in Jesus Name";
    }


    @GetMapping("/patients")
    @Operation(summary = "Get all Patients")
    public ResponseEntity<List<Patient>> getAllPatient() {

        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @PostMapping("/patients")
    @Operation(summary = "Register a new Patient")
    public ResponseEntity<PatientResponseDto> registerPatient(@Valid @RequestBody PatientRequestDto requestDto) {
        PatientResponseDto responseDto = patientService.registerPatient(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }
}
