package com.example.demo.controllers;

import com.example.demo.domains.Booking;
import com.example.demo.domains.dtos.BookingDTO;
import com.example.demo.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService service;

    @GetMapping()
    public ResponseEntity<List<BookingDTO>> getAllBookings(){
        try{
            List<BookingDTO> bookings  = this.service.findAll();
            return new ResponseEntity<>(bookings, HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
        try{
            Booking booking = this.service.findById(id);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
