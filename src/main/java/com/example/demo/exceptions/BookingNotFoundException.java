package com.example.demo.exceptions;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
