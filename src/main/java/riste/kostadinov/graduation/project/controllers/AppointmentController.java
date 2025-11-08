package riste.kostadinov.graduation.project.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import riste.kostadinov.graduation.project.domains.Appointment;
import riste.kostadinov.graduation.project.domains.dtos.AppointmentRequest;
import riste.kostadinov.graduation.project.domains.dtos.projections.AppointmentProjection;
import riste.kostadinov.graduation.project.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
@AllArgsConstructor
@Slf4j
public class AppointmentController {
    private final AppointmentService service;

    @PostMapping("create")
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        log.info("request hit this endpoint");
        return new ResponseEntity<>(this.service.save(appointmentRequest), HttpStatus.OK);
    }

}
