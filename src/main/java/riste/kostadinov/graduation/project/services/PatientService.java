package riste.kostadinov.graduation.project.services;
import riste.kostadinov.graduation.project.domains.Patient;
import riste.kostadinov.graduation.project.domains.dtos.PatientDTO;
import riste.kostadinov.graduation.project.domains.dtos.PatientRequest;

import java.util.List;

public interface PatientService {
    Patient save(PatientRequest patientRequest);
    List<PatientDTO> listAll();
    Patient findById(Long id);
    Patient edit(Long id, PatientRequest patient);
    void delete(Long id);
    Patient updateInsurance(Long id);
}
