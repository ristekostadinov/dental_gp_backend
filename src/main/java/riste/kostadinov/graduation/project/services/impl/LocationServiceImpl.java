package riste.kostadinov.graduation.project.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import riste.kostadinov.graduation.project.domains.Location;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;
import riste.kostadinov.graduation.project.exceptions.LocationNotFoundException;
import riste.kostadinov.graduation.project.repositories.LocationRepository;
import riste.kostadinov.graduation.project.services.LocationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {
    private final LocationRepository repository;

    @Override
    public Page<LocationDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.repository.findAll(pageable)
                .map(location -> new LocationDTO(location.getId(), location.getName()));
    }

    @Override
    public Location findById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(()-> new LocationNotFoundException("Location with id " + id + " not found"));
    }

    @Override
    public List<LocationDTO> findAllNonPaginated() {
        return this.repository
                .findAll()
                .stream()
                .map(location -> new LocationDTO(location.getId(), location.getName()))
                .collect(Collectors.toList());
    }
}
