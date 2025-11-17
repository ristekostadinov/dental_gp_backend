package riste.kostadinov.graduation.project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import riste.kostadinov.graduation.project.domains.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import riste.kostadinov.graduation.project.domains.dtos.projections.AppointmentProjection;
import riste.kostadinov.graduation.project.domains.dtos.projections.PatientAppointmentProjection;

import java.time.OffsetDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("""
        SELECT a.id as id,
               a.fromDateTime as fromDateTime ,
               a.toDateTime as toDateTime
        FROM Appointment a
        WHERE a.status = 'BOOKED'
          AND a.fromDateTime >= :from
          AND a.toDateTime <= :to
          AND a.resource.id = :resourceId
    """)
    List<AppointmentProjection> getBookedAppointments(
            @Param("from") OffsetDateTime from,
            @Param("to") OffsetDateTime to,
            @Param("resourceId") Long resourceId
    );

    @Query("""
    SELECT a.id AS id,
           a.resource.name AS resourceName,
           a.dentalService.name AS dentalServiceName,
           a.fromDateTime AS fromDateTime,
           a.toDateTime AS toDateTime
    FROM Appointment a
    WHERE a.patient.email = :email
      AND a.status = 'BOOKED'
    """)
    List<PatientAppointmentProjection> getBookedAppointmentsByPatient(@Param("email") String email);



}
