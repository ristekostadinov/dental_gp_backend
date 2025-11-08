package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PublicDataService {
    List<DentalServiceDTO> listDentalServices(Long categoryId, Long locationId);
    List<ResourceServiceDTO> listResources(Long locationId, Long serviceId);
    List<CategoryDTO> listCategories();
    List<LocationDTO> listLocations();
    DentalServiceDTO getDentalService(Long dentalServiceId);
    List<AppointmentDTO> getBookedAppointments(LocalDate date,  Long resourceId);
    Resource getResourceById(Long resourceId);
}
