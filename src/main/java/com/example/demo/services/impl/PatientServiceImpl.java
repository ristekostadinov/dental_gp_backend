package com.example.demo.services.impl;

import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.PatientDTO;
import com.example.demo.domains.dtos.PatientRequest;
import com.example.demo.domains.dtos.projections.PatientProjection;
import com.example.demo.exceptions.PatientNotFoundException;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.PatientService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;

    @Override
    public List<PatientDTO> listAll() {
        return repository.findAllPatients()
                .stream().
                map(PatientProjection::toPatientDTO).
                collect(Collectors.toList());
    }

    @Override
    public Patient findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient with id"+id+" not found"));
    }

    @Override
    @Transactional
    public Patient save(PatientRequest patientRequest) {
        log.info("Saving patient {}", patientRequest);
        var patient = new Patient();
        patient.setFirstName(patientRequest.firstName());
        patient.setLastName(patientRequest.lastName());
        patient.setEmail(patientRequest.email());
        patient.setPhoneNumber(patientRequest.phoneNumber());
        patient.setInsurance(patientRequest.insurance());
        return repository.save(patient);
    }

    @Override
    @Transactional
    public Patient edit(Long id, PatientRequest patient){
        var result = this.findById(id);
        result.setFirstName(patient.firstName());
        result.setLastName(patient.lastName());
        result.setEmail(patient.email());
        result.setPhoneNumber(patient.phoneNumber());
        result.setInsurance(patient.insurance());
        return repository.save(result);
    }

    @Override
    public Patient updateInsurance(Long id) {
        Patient patient = this.findById(id);
        patient.setInsurance(!patient.isInsurance());
        return repository.save(patient);
    }

    @Override
    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
