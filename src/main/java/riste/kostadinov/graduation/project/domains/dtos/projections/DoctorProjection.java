package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.dtos.DoctorDTO;

public interface DoctorProjection {
    Long getId();
    String getFirstName();
    String getLastName();

    default DoctorDTO toDTO() {
        return new DoctorDTO(getId(), getFirstName(), getLastName());
    }
}
