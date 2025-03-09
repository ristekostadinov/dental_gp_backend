package riste.kostadinov.graduation.project.services.impl;

import riste.kostadinov.graduation.project.domains.Appointment;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentRequest;
import riste.kostadinov.graduation.project.exceptions.AppointmentNotFoundException;
import riste.kostadinov.graduation.project.repositories.AppointmentRepository;
import riste.kostadinov.graduation.project.services.AppointmentService;
import riste.kostadinov.graduation.project.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final UserService userService;

    @Override
    public void create(AppointmentRequest request) {

    }

    @Override
    public Appointment findById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() ->  new AppointmentNotFoundException("Appointment with id " + id + " not found"));
    }


    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
