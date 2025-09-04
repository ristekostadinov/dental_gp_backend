package riste.kostadinov.graduation.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;
import riste.kostadinov.graduation.project.domains.dtos.ResourceServiceDTO;
import riste.kostadinov.graduation.project.services.PublicDataService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController()
@RequestMapping("/api/public")
@AllArgsConstructor
public class PublicDataController {
    private final PublicDataService publicDataService;
    @GetMapping("categories/{categoryId}/locations/{locationId}/services")
    public ResponseEntity<List<DentalServiceDTO>> getDentalServices(@PathVariable Long categoryId, @PathVariable Long locationId) {
        try{
            List<DentalServiceDTO> services = this.publicDataService.listDentalServices(categoryId, locationId);
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("locations/{locationId}/services/{serviceId}/resources")
    public ResponseEntity<List<ResourceServiceDTO>> getResources(@PathVariable Long locationId, @PathVariable Long serviceId) {
        return new ResponseEntity<>(this.publicDataService.listResources(locationId, serviceId), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        try{
            List<CategoryDTO> categories = this.publicDataService.listCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationDTO>> getLocations(){
        try{
            List<LocationDTO> locations = this.publicDataService.listLocations();
            return new ResponseEntity<>(locations, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/services/{serviceId}")
    public ResponseEntity<DentalServiceDTO> getService(@PathVariable Long serviceId){
        try{
            DentalServiceDTO dentalServiceDTO = this.publicDataService.getDentalService(serviceId);
            return new ResponseEntity<>(dentalServiceDTO, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
