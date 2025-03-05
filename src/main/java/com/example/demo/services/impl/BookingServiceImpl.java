package com.example.demo.services.impl;

import com.example.demo.domains.Booking;
import com.example.demo.exceptions.BookingNotFoundException;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.services.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    @Override
    public Booking findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookingNotFoundException("Treatment with id:"+id+" not found"));
    }

    @Override
    public Booking save(Booking treatment) {
        return null;
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {

    }
}
