package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;
import riste.kostadinov.graduation.project.domains.dtos.ResourceServiceDTO;

import java.util.List;

public interface PublicDataService {
    List<DentalServiceDTO> listDentalServices(Long categoryId, Long locationId);
    List<ResourceServiceDTO> listResources(Long locationId, Long serviceId);
    List<CategoryDTO> listCategories();
    List<LocationDTO> listLocations();
    DentalServiceDTO getDentalService(Long dentalServiceId);
}
