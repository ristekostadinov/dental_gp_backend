package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.Booking;
import riste.kostadinov.graduation.project.domains.dtos.projections.BookingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b.id as id, b.fromTimestamp as fromTimestamp, b.toTimestamp as toTimestamp  from Booking b")
    List<BookingProjection> findAllBookings();
}
