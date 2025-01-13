package com.example.demo.repositories;

import com.example.demo.domains.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {
    @Query(value = """
            SELECT p FROM Patient p WHERE p.lastName ilike :lastName
            """)
    List<Patient> Zemi(@Param("lastName") String lastName);

    @Query(value = """
            SELECT * FROM patients p WHERE p.last_name ilike :lastName
            """, nativeQuery = true)
    List<Patient> ZemiNative(@Param("lastName") String lastName);

    List<Patient> findAllByLastNameLikeIgnoreCase(String lastName);

    List<Patient> findPatientsByLastNameLikeIgnoreCase(String lastName);
    List<Patient> findPatientsByLastNameNotContainingIgnoreCase(String lastName);
    List<Patient> findPatientsByLastNameStartingWithIgnoreCase(String lastName);
    List<Patient> findPatientsByLastNameEndingWithIgnoreCase(String lastName);
    List<Patient> findPatientsByIdIn(Collection<Long> ids);
    List<Patient> findPatientsByInsuranceIsFalse();
}
