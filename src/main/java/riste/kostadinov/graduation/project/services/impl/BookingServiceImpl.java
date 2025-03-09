package riste.kostadinov.graduation.project.services.impl;

import riste.kostadinov.graduation.project.domains.Booking;
import riste.kostadinov.graduation.project.domains.dtos.BookingDTO;
import riste.kostadinov.graduation.project.domains.dtos.BookingRequest;
import riste.kostadinov.graduation.project.domains.dtos.projections.BookingProjection;
import riste.kostadinov.graduation.project.domains.enums.BookingStatus;
import riste.kostadinov.graduation.project.exceptions.BookingNotFoundException;
import riste.kostadinov.graduation.project.repositories.BookingRepository;
import riste.kostadinov.graduation.project.services.BookingService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    @Override
    public Booking findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookingNotFoundException("Treatment with id:"+id+" not found"));
    }

    @Transactional
    @Override
    public Booking save(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setFromTimestamp(booking.getFromTimestamp());
        booking.setToTimestamp(booking.getToTimestamp());
        booking.setStatus(BookingStatus.CREATED);
        return repository.save(booking);
    }

    @Override
    public List<BookingDTO> findAll() {
        return repository.findAllBookings().stream().map(BookingProjection::toBookingDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {

    }
}
