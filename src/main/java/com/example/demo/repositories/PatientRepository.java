package com.example.demo.repositories;

import com.example.demo.domains.Patient;
import com.example.demo.domains.dtos.projections.PatientProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {
    @Query("select p.id as id, p.firstName as firstName, p.lastName as lastName from Patient p")
    List<PatientProjection> findAllPatients();
}
