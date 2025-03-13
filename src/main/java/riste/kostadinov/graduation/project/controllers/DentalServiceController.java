package riste.kostadinov.graduation.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riste.kostadinov.graduation.project.domains.DentalService;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceRequest;
import riste.kostadinov.graduation.project.services.DentalServiceManager;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/dental-services")
@AllArgsConstructor
public class DentalServiceController {
    private final DentalServiceManager service;

    @GetMapping()
    public ResponseEntity<Page<DentalServiceDTO>> getAllDentalServices(@RequestParam int page, @RequestParam int size) {
        try{
            Page<DentalServiceDTO> dentalServices = this.service.findAll(page, size);
            return new ResponseEntity<>(dentalServices, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<DentalService> createDentalService(@RequestBody DentalServiceRequest dentalServiceRequest){
        return new ResponseEntity<>(this.service.save(dentalServiceRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentalServiceDTO> getDentalServiceById(@PathVariable Long id){
        try{
            DentalService dentalService = this.service.findById(id);
            return new ResponseEntity<>(new DentalServiceDTO(dentalService.getId(), dentalService.getName()), HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DentalService> editDentalService(@PathVariable Long id, @RequestBody DentalServiceRequest dentalServiceRequest){
        try{
            DentalService dentalService = this.service.findById(id);
            this.service.edit(id, dentalServiceRequest);
            return new ResponseEntity<>(dentalService, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDentalService(@PathVariable Long id){
        this.service.delete(id);
    }
}
