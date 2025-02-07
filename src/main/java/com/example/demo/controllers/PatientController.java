package com.example.demo.controllers;

import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.PatientDTO;
import com.example.demo.domains.dtos.PatientRegistrationDTO;
import com.example.demo.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/")
    public ResponseEntity<Patient> createPatient(@RequestBody PatientRegistrationDTO patient) {
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        try {
            List<PatientDTO> patients = patientService.listAll();
            return new ResponseEntity<>(patients, HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        try {
            Patient patient = patientService.findById(id);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientRegistrationDTO patientDTO) {
        try {
            Patient patient = patientService.findById(id);
            patient.setFirstName(patientDTO.firstName());
            patient.setLastName(patientDTO.lastName());
            patient.setEmail(patientDTO.email());
            patient.setInsurance(patientDTO.insurance());

            return new ResponseEntity<>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.delete(id);
    }
}
