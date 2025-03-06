package com.example.demo.exceptions;

public class DentalServiceNotFound extends RuntimeException {
    public DentalServiceNotFound(String message) {
        super(message);
    }
}
