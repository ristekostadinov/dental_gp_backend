package com.example.demo.services;
import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.PatientRegistrationDTO;

import java.util.List;

public interface PatientService {
    Patient save(PatientRegistrationDTO patientRegistrationDTO);
    List<Patient> findAll();
    Patient findById(Long id);
    Patient edit(Long id, PatientRegistrationDTO patient);
    void delete(Long id);
    Patient updateInstance(Long id);
}
