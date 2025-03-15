package riste.kostadinov.graduation.project.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import riste.kostadinov.graduation.project.domains.DentalService;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.DentalServiceRequest;
import riste.kostadinov.graduation.project.exceptions.DentalServiceNotFound;
import riste.kostadinov.graduation.project.repositories.DentalServiceRepository;
import riste.kostadinov.graduation.project.services.DentalServiceManager;

@Service
@AllArgsConstructor
public class DentalServiceManagerImpl implements DentalServiceManager {
    private final DentalServiceRepository repository;

    @Transactional
    @Override
    public DentalService save(DentalServiceRequest dentalServiceRequest) {
        DentalService dentalService = new DentalService();
        dentalService.setName(dentalServiceRequest.name());
        return this.repository.save(dentalService);
    }

    @Transactional
    @Override
    public DentalService edit(Long id, DentalServiceRequest dentalServiceRequest) {
        DentalService dentalService = this.findById(id);
        dentalService.setName(dentalServiceRequest.name());
        return this.repository.save(dentalService);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public DentalService findById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(()-> new DentalServiceNotFound("Dental Service with id: "+id+" not found"));

    }

    @Override
    public Page<DentalServiceDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return  this.repository
                .findAll(pageable)
                .map(service -> new DentalServiceDTO(service.getId(), service.getName()));
    }
}
