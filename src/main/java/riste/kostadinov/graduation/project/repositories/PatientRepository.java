package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.Patient;
import riste.kostadinov.graduation.project.domains.dtos.projections.PatientProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {
    @Query("select p.id as id, p.firstName as firstName, p.lastName as lastName, p.insurance as insurance from Patient p")
    List<PatientProjection> findAllPatients();

    Optional<Patient> findByEmail(String email);
}
