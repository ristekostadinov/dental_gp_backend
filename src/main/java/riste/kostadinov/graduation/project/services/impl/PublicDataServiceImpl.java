package riste.kostadinov.graduation.project.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import riste.kostadinov.graduation.project.domains.Category;
import riste.kostadinov.graduation.project.domains.DentalService;
import riste.kostadinov.graduation.project.domains.Location;
import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.LocationDTO;
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
    public List<Resource> listResources(String service) {
        return List.of();
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
