package com.example.demo.services.impl;

import com.example.demo.domains.Booking;
import com.example.demo.domains.dtos.BookingDTO;
import com.example.demo.domains.dtos.BookingRequest;
import com.example.demo.domains.dtos.projections.BookingProjection;
import com.example.demo.domains.enums.BookingStatus;
import com.example.demo.exceptions.BookingNotFoundException;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.services.BookingService;
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
