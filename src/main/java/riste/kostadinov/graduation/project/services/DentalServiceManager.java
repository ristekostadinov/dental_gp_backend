package riste.kostadinov.graduation.project.services;

import org.springframework.data.domain.Page;
import riste.kostadinov.graduation.project.domains.DentalService;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceRequest;

public interface DentalServiceManager {
    DentalService save(DentalServiceRequest dentalServiceRequest);
    DentalService edit(Long id, DentalServiceRequest dentalServiceRequest);
    void delete(Long id);
    DentalService findById(Long id);
    Page<DentalServiceDTO> findAll(int page, int size);
}
