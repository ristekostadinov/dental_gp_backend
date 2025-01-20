package com.example.demo.controllers;

import com.example.demo.domains.Patient;
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
    private final PatientService service;

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody PatientRegistrationDTO patient) {
        return new ResponseEntity<>(service.save(patient), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            List<Patient> patients = service.findAll();
            return new ResponseEntity<>(patients, HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        try {
            Patient patient = service.findById(id);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientRegistrationDTO patientDTO) {
        try {
            Patient patient = service.edit(id, patientDTO);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Patient> updateInsurance(@PathVariable Long id) {
        try {
            Patient patient = service.updateInstance(id);
            return new ResponseEntity<>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.delete(id);
    }
}
