package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Appointment;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentDTO;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentRequest;

import java.time.ZonedDateTime;
import java.util.List;


public interface AppointmentService {
    Appointment save(AppointmentRequest request);
    Appointment findById(Long id);
    void delete(Long id);
    List<AppointmentDTO> getBookedAppointments(ZonedDateTime from, ZonedDateTime to, Long resourceId);
    void cancel(AppointmentRequest request);
}
