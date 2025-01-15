package com.example.demo.controllers;

import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.PatientRegistrationDTO;
import com.example.demo.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/")
    public ResponseEntity<Patient> createPatient(@RequestBody PatientRegistrationDTO patient) {
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.OK);
    }

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.delete(id);
    }
}
