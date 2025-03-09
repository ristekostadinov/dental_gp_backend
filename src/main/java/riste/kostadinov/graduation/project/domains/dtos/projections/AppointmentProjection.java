package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.dtos.AppointmentDTO;

import java.time.ZonedDateTime;

public interface AppointmentProjection {
    Long getId();
    ZonedDateTime getFrom();
    ZonedDateTime getTo();

    default AppointmentDTO toDTO(){
        return new AppointmentDTO(getId(), getFrom(), getTo());
    }
}
