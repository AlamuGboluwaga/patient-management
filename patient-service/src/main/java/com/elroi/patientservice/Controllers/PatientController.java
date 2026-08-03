package com.elroi.patientservice.Controllers;

import com.elroi.patientservice.dto.PatientRequestDto;
import com.elroi.patientservice.dto.PatientResponseDto;
import com.elroi.patientservice.model.Patient;
import com.elroi.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Patient APIs", description = "Controller for managing patients")

public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/api/test")
    @Operation(summary = "Test Endpoint", description = "Returns a test message to verify the service is running.")
    public String test() {
        return "It is settled in Jesus Name";
    }


    @GetMapping("/api/patients/all")
    @Operation(summary = "Get all Patients")
    public ResponseEntity<List<Patient>> getAllPatient() {

        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @PostMapping("/api/patients")
    @Operation(summary = "Register a new Patient")
    public ResponseEntity<PatientResponseDto> registerPatient(@Valid @RequestBody PatientRequestDto requestDto) {
        PatientResponseDto responseDto = patientService.registerPatient(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/api/patients/{email}")
    @Operation(summary = "Get patient by email", description = "Retrieve a patient by their email address")
    public ResponseEntity<PatientResponseDto> getPatientByEmail(@Valid @PathVariable String email) {
        return ResponseEntity.ok().body(patientService.getPatientByEmail(email));
    }

    @DeleteMapping("/api/patients/{email}")
    @Operation(summary = "Delete patient by email", description = "Delete a patient by their email address")
    public String deletePatientByEmail(@Valid @PathVariable String email) {
        return ResponseEntity.ok().body(patientService.deletePatientByEmail(email)).getBody();
    }

    @PutMapping("/api/patients/{email}")
    @Operation(summary = "Update patient by email", description = "Update a patient's information by their email address")
    public ResponseEntity<PatientResponseDto> updatePatient(@Valid @PathVariable String email, @Valid @RequestBody PatientRequestDto requestDto) {
        PatientResponseDto responseDto = patientService.updatePatient(email, requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

}
