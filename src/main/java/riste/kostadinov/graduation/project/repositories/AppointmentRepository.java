package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
