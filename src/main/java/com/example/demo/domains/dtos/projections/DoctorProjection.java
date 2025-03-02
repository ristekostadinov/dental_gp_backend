package com.example.demo.domains.dtos.projections;

import com.example.demo.domains.dtos.DoctorDTO;

public interface DoctorProjection {
    Long getId();
    String getFirstName();
    String getLastName();

    default DoctorDTO toDTO() {
        return new DoctorDTO(getId(), getFirstName(), getLastName());
    }
}
