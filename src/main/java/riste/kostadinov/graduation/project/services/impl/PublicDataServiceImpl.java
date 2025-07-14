package riste.kostadinov.graduation.project.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import riste.kostadinov.graduation.project.domains.DentalService;
import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;
import riste.kostadinov.graduation.project.domains.dtos.ResourceServiceDTO;
import riste.kostadinov.graduation.project.services.*;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PublicDataServiceImpl implements PublicDataService {
    private final LocationService locationService;
    private final DentalServiceManager dentalServiceManager;
    private final ResourceService resourceService;
    private final CategoryService categoryService;


    @Override
    public List<DentalServiceDTO> listDentalServices(Long categoryId, Long locationId) {
        return this.dentalServiceManager.findAllDentalServices(categoryId, locationId);
    }

    @Override
    public DentalServiceDTO getDentalService(Long dentalServiceId){
        DentalService dentalService =  this.dentalServiceManager.findById(dentalServiceId);
        return new DentalServiceDTO(dentalService.getId(), dentalService.getName());
    }

    @Override
    public List<ResourceServiceDTO> listResources(Long locationId, Long serviceId) {
        return resourceService.findAllResources(locationId, serviceId);
    }

    @Override
    public List<CategoryDTO> listCategories() {
        return categoryService.findAll();
    }

    @Override
    public List<LocationDTO> listLocations() {
        return locationService.findAllNonPaginated();
    }

}
