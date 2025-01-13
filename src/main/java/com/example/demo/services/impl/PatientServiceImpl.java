package com.example.demo.services.impl;

import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.PatientRegistrationDTO;
import com.example.demo.exceptions.PatientNotFoundException;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.PatientService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient with id"+id+" not found"));
    }

    @Override
    @Transactional
    public Patient save(PatientRegistrationDTO patientRegistrationDTO) {
        log.info("Saving patient {}", patientRegistrationDTO);
        var patient = new Patient();
        patient.setFirstName(patientRegistrationDTO.firstName());
        patient.setLastName(patientRegistrationDTO.lastName());
        patient.setEmail(patientRegistrationDTO.email());
        patient.setPhoneNumber(patientRegistrationDTO.phoneNumber());
        patient.setInsurance(patientRegistrationDTO.insurance());
        return patientRepository.save(patient);
    }

    @Override
    @Transactional
    public Patient edit(Long id, Patient patient){
        var result = this.findById(id);
        result.setFirstName(patient.getFirstName());
        result.setLastName(patient.getLastName());
        result.setEmail(patient.getEmail());
        result.setPhoneNumber(patient.getPhoneNumber());
        return patientRepository.save(result);
    }
}
