package com.example.demo.domains.dtos.projections;

import com.example.demo.domains.dtos.PatientDTO;

public interface PatientProjection {
    Long getId();
    String getFirstName();
    String getLastName();
    boolean getInsurance();
    default PatientDTO toPatientDTO() {
        return new PatientDTO(getId(), getFirstName(), getLastName(), getInsurance());
    }
}
