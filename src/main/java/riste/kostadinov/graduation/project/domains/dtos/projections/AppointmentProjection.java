package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.dtos.AppointmentDTO;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public interface AppointmentProjection {
    Long getId();
    OffsetDateTime getFromDateTime();
    OffsetDateTime getToDateTime();

    default AppointmentDTO toDTO(){
        return new AppointmentDTO(getId(), getFromDateTime(), getToDateTime());
    }
}
