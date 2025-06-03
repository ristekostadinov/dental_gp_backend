package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;

public interface DentalServiceProjection {
    Long getId();
    String getName();
    default DentalServiceDTO toDTO() {
        return new DentalServiceDTO(getId(), getName());
    }
}
