package riste.kostadinov.graduation.project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import riste.kostadinov.graduation.project.domains.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import riste.kostadinov.graduation.project.domains.dtos.projections.AppointmentProjection;

import java.time.ZonedDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(value = """
    SELECT a.id, a.date_time_from, a.date_time_to
    FROM appointments a
    WHERE a.status = 'BOOKED'
      AND a.date_time_from >= :dateTimeFrom
      AND a.date_time_to <= :dateTimeTo
      AND a.resource_id = :resourceId
    """, nativeQuery = true)
    List<AppointmentProjection> getBookedAppointments(@Param("dateTimeFrom") ZonedDateTime dateTimeFrom, @Param("dateTimeTo") ZonedDateTime dateTimeTo, @Param("resourceId") Long resourceId);
}
