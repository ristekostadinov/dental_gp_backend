package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.dtos.PatientDTO;

public interface PatientProjection {
    Long getId();
    String getFirstName();
    String getLastName();
    boolean getInsurance();
    default PatientDTO toPatientDTO() {
        return new PatientDTO(getId(), getFirstName(), getLastName(), getInsurance());
    }
}
