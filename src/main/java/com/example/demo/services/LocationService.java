package com.example.demo.services;

import com.example.demo.domains.dtos.LocationDTO;

import java.util.List;

public interface LocationService {
    List<LocationDTO> findAllLocations();
}
