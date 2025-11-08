package riste.kostadinov.graduation.project.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import riste.kostadinov.graduation.project.domains.Patient;
import riste.kostadinov.graduation.project.domains.dtos.PatientDTO;
import riste.kostadinov.graduation.project.domains.dtos.PatientRequest;
import riste.kostadinov.graduation.project.domains.dtos.projections.PatientProjection;
import riste.kostadinov.graduation.project.exceptions.PatientNotFoundException;
import riste.kostadinov.graduation.project.exceptions.UserAlreadyExistException;
import riste.kostadinov.graduation.project.repositories.PatientRepository;
import riste.kostadinov.graduation.project.services.PatientService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;
    private final PasswordEncoder passwordEncoder;

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
        if(this.repository.findByEmail(patientRequest.email()).isPresent()){
            throw new UserAlreadyExistException("User with email "+patientRequest.email()+" already exists");
        }
        log.info("Saving patient {}", patientRequest);
        var patient = new Patient();
        patient.setFirstName(patientRequest.firstName());
        patient.setLastName(patientRequest.lastName());
        patient.setEmail(patientRequest.email());
        patient.setPhoneNumber(patientRequest.phoneNumber());
        patient.setInsurance(patientRequest.insurance());
        patient.setPassword(passwordEncoder.encode(patientRequest.password()));
        return repository.save(patient);
    }

    @Override
    @Transactional
    public Patient edit(Long id, PatientRequest patientRequest){
        log.debug("Updating patient {}", patientRequest);
        Patient patient = this.findById(id);
        patient.setFirstName(patientRequest.firstName());
        patient.setLastName(patientRequest.lastName());
        patient.setEmail(patientRequest.email());
        patient.setPhoneNumber(patientRequest.phoneNumber());
        patient.setInsurance(patientRequest.insurance());
        return repository.save(patient);
    }

    @Override
    public Patient updateInsurance(Long id) {
        Patient patient = this.findById(id);
        patient.setInsurance(!patient.isInsurance());
        return repository.save(patient);
    }

    @Override
    public Patient findByEmail(String email) {
        return this.repository.findByEmail(email).orElseThrow(()-> new PatientNotFoundException("Patient with id"+email+" not found"));
    }

    @Override
    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
