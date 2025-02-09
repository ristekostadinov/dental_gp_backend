package com.example.demo.services;
import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.PatientDTO;
import com.example.demo.domains.dtos.PatientRequest;

import java.util.List;

public interface PatientService {
    Patient save(PatientRequest patientRequest);
    List<PatientDTO> listAll();
    Patient findById(Long id);
    Patient edit(Long id, PatientRequest patient);
    void delete(Long id);
    Patient updateInsurance(Long id);
}
