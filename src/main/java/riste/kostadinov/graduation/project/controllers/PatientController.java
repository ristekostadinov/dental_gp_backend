package riste.kostadinov.graduation.project.controllers;

import riste.kostadinov.graduation.project.domains.Patient;
import riste.kostadinov.graduation.project.domains.dtos.PatientDTO;
import riste.kostadinov.graduation.project.domains.dtos.PatientRequest;
import riste.kostadinov.graduation.project.services.PatientService;
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

    @PostMapping()
    public ResponseEntity<Patient> createPatient(@RequestBody PatientRequest request) {
        return new ResponseEntity<>(patientService.save(request), HttpStatus.OK);
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
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientRequest patientRequest) {
        try {
            Patient patient = patientService.findById(id);
            this.patientService.edit(id, patientRequest);
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
