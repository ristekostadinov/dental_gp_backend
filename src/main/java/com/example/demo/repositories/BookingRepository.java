package com.example.demo.repositories;

import com.example.demo.domains.Booking;
import com.example.demo.domains.dtos.projections.BookingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b.id as id, b.fromTimestamp as fromTimestamp, b.toTimestamp as toTimestamp  from Booking b")
    List<BookingProjection> findAllBookings();
}
