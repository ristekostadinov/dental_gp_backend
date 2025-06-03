package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.DentalService;
import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;

import java.util.List;

public interface PublicDataService {
    List<DentalServiceDTO> listDentalServices(Long categoryId, Long locationId);
    List<Resource> listResources(String service);
    List<CategoryDTO> listCategories();
    List<LocationDTO> listLocations();
}
