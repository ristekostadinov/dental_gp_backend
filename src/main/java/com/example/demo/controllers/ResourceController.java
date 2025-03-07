package com.example.demo.controllers;

import com.example.demo.domains.Resource;
import com.example.demo.domains.dtos.ResourceDTO;
import com.example.demo.domains.dtos.ResourceRequest;
import com.example.demo.services.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@AllArgsConstructor
@RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceService service;

    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        try{
            List<ResourceDTO> resources =  service.findAll();
            return new ResponseEntity<>(resources, HttpStatus.CREATED);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        try{
            Resource resource = service.findById(id);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody ResourceRequest resourceRequest) {
        return new ResponseEntity<>(service.save(resourceRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody ResourceRequest resourceRequest) {
        try{
            Resource resource = service.findById(id);
            this.service.edit(id, resourceRequest);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        this.service.delete(id);
    }
}
