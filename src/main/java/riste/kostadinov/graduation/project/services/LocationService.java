package riste.kostadinov.graduation.project.services;

import org.springframework.data.domain.Page;
import riste.kostadinov.graduation.project.domains.Location;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;

import java.util.List;

public interface LocationService {
    Page<LocationDTO> findAll(int page, int size);
    Location findById(Long id);
    List<LocationDTO> findAllNonPaginated();
}
