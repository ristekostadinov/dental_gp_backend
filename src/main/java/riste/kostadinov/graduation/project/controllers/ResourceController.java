package riste.kostadinov.graduation.project.controllers;

import org.springframework.data.domain.Page;
import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.ResourceDTO;
import riste.kostadinov.graduation.project.domains.dtos.ResourceRequest;
import riste.kostadinov.graduation.project.services.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceService service;

    @GetMapping
    public ResponseEntity<Page<ResourceDTO>> getAllResources(@RequestParam int page, @RequestParam int size) {
        try{
            Page<ResourceDTO> resources =  service.findAll(page, size);
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
