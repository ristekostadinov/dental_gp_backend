package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.dtos.ResourceServiceDTO;

public interface ResourceServiceProjection {
    Long getId();
    String getName();
    String getAddress();
    String getDescription();
    int getPrice();
    default ResourceServiceDTO toDTO() {
        return new ResourceServiceDTO(getId(), getName(), getAddress(), getDescription(), getPrice());
    }
}
