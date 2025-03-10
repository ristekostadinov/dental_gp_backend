package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;

import java.util.List;

public interface LocationService {
    List<LocationDTO> findAllLocations();
}
