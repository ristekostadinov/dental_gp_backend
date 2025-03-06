package com.example.demo.repositories;

import com.example.demo.domains.Location;
import com.example.demo.domains.dtos.LocationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query()
    List<LocationDTO> findAllLocations();
}
