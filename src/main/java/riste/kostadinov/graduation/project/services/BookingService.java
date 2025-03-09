package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Booking;
import riste.kostadinov.graduation.project.domains.dtos.BookingDTO;
import riste.kostadinov.graduation.project.domains.dtos.BookingRequest;

import java.util.List;

public interface BookingService {
    Booking findById(Long id);
    Booking save(BookingRequest bookingRequest);
    List<BookingDTO> findAll();
    void deleteById(Long id);
}
