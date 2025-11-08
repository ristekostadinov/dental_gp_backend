package riste.kostadinov.graduation.project.services.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import riste.kostadinov.graduation.project.domains.Appointment;
import riste.kostadinov.graduation.project.domains.Patient;
import riste.kostadinov.graduation.project.domains.DentalService;
import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentDTO;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentRequest;
import riste.kostadinov.graduation.project.domains.dtos.projections.AppointmentProjection;
import riste.kostadinov.graduation.project.domains.enums.AppointmentStatus;
import riste.kostadinov.graduation.project.exceptions.AppointmentNotFoundException;
import riste.kostadinov.graduation.project.repositories.AppointmentRepository;
import riste.kostadinov.graduation.project.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final UserService userService;
    private final DentalServiceManager dentalServiceManager;
    private final PatientService patientService;
    private final ResourceService resourceService;

    @Override
    @Transactional
    public Appointment save(AppointmentRequest request) {
        Appointment appointment = new Appointment();
        DentalService dentalService = this.dentalServiceManager.findById(request.dentalServiceId());
        Patient patient = this.patientService.findByEmail(request.patientEmail());
        Resource resource = this.resourceService.findById(request.resourceId());

        appointment.setDentalService(dentalService);
        appointment.setPatient(patient);
        appointment.setResource(resource);
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setFrom(request.from());
        appointment.setTo(request.to());

        return this.repository.save(appointment);
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

    @Override
    public List<AppointmentDTO> getBookedAppointments(ZonedDateTime from, ZonedDateTime to, Long resourceId) {
// 1.
        return this.repository.getBookedAppointments(from, to, resourceId)
                .stream()
                .map(AppointmentProjection::toDTO)
                .toList();
    }

    @Override
    public void cancel(AppointmentRequest request) {

    }
}
