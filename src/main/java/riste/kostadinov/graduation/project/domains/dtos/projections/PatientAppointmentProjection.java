package riste.kostadinov.graduation.project.domains.dtos.projections;

import riste.kostadinov.graduation.project.domains.dtos.AppointmentDTO;
import riste.kostadinov.graduation.project.domains.dtos.PatientAppointmentDTO;

import java.time.OffsetDateTime;

public interface PatientAppointmentProjection {
    Long getId();
    String getResourceName();
    String getDentalServiceName();
    OffsetDateTime getFromDateTime();
    OffsetDateTime getToDateTime();



    default PatientAppointmentDTO toDTO(){
        return new PatientAppointmentDTO(getId(),getResourceName(), getDentalServiceName(), getFromDateTime(), getToDateTime());
    }
}
