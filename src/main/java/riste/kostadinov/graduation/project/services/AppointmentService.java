package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Appointment;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentRequest;


public interface AppointmentService {
    void create(AppointmentRequest request);
    Appointment findById(Long id);
    void delete(Long id);
}
