package riste.kostadinov.graduation.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riste.kostadinov.graduation.project.domains.Location;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;
import riste.kostadinov.graduation.project.services.LocationService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/locations")
@AllArgsConstructor
public class LocationController {
    private final LocationService service;

    @GetMapping()
    public ResponseEntity<Page<LocationDTO>> getAllLocations(@RequestParam int page, @RequestParam int size) {
        try{
            Page<LocationDTO> locations = this.service.findAll(page, size);
            return new ResponseEntity<>(locations, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable long id) {
        try{
            Location location = this.service.findById(id);
            return new ResponseEntity<>(location, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
