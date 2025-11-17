package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Appointment;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentDTO;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentRequest;
import riste.kostadinov.graduation.project.domains.dtos.PatientAppointmentDTO;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;


public interface AppointmentService {
    Appointment save(AppointmentRequest request);
    Appointment findById(Long id);
    void delete(Long id);
    List<AppointmentDTO> getBookedAppointments(OffsetDateTime from, OffsetDateTime to, Long resourceId);
    Appointment cancel(Long id);
    List<PatientAppointmentDTO> getBookedAppointmentsByPatient(String email);
}
