package com.example.demo.services.impl;

import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.PatientRegistrationDTO;
import com.example.demo.exceptions.PatientNotFoundException;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.PatientService;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new PatientNotFoundException("Patient with id"+id+" not found"));
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
        return repository.save(patient);
    }

    @Override
    @Transactional
    public Patient edit(Long id, PatientRegistrationDTO patient){
        var result = this.findById(id);
        result.setFirstName(patient.firstName());
        result.setLastName(patient.lastName());
        result.setEmail(patient.email());
        result.setPhoneNumber(patient.phoneNumber());
        return repository.save(result);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public Page<Patient> demoSpecification(String name, String lastName, String email, String phoneNumber, String insurance) {
        Specification<Patient> specification = (root, query, cb)
                -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null || !name.isBlank()) {
                predicates.add(cb.like(root.get("firstName"), name));
            }
            if (lastName != null) {
                predicates.add(cb.like(root.get("lastName"), lastName));
            }
            if (email != null) {
                predicates.add(cb.like(root.get("email"), email));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        final var a =  repository.findAll(specification, Pageable.ofSize(10)); //n

        /*a.forEach(it -> {
            var b = repository.findById(it.getId()).get(); //1
            b.setInsurance(true);
            repository.save(b);//1
        });*/

        final Set<Long> ids = a.getContent().stream().map(Patient::getId).collect(Collectors.toSet());
        return repository.findAll(specification, Pageable.ofSize(10));
    }

    private List<Patient> findPatientsWithOutInsurance() {
        return repository.findPatientsByInsuranceIsFalse();
    }

    public void updateAllPatientsInsurance(){
        //        final List<Patient> withOutInsurance = repository.findPatientsByIdIn(ids);
        final List<Patient> withOutInsurance = findPatientsWithOutInsurance();

        final List<Patient> withUpdatedInsurance = withOutInsurance.stream()
                .map(patient -> {
                    Patient clonedPatient = patient.clone();
                    clonedPatient.setInsurance(true);
                    return clonedPatient;
                })
                .toList();
        repository.saveAllAndFlush(withUpdatedInsurance);
    }
}
