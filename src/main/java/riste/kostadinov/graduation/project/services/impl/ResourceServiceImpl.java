package riste.kostadinov.graduation.project.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.ResourceDTO;
import riste.kostadinov.graduation.project.domains.dtos.ResourceRequest;
import riste.kostadinov.graduation.project.domains.dtos.ResourceServiceDTO;
import riste.kostadinov.graduation.project.domains.dtos.projections.ResourceServiceProjection;
import riste.kostadinov.graduation.project.exceptions.ResourceNotFoundException;
import riste.kostadinov.graduation.project.repositories.ResourceRepository;
import riste.kostadinov.graduation.project.services.ResourceService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResourceServiceImpl implements ResourceService {
    private final ResourceRepository repository;
    @Override
    @Transactional
    public Resource save(ResourceRequest resourceRequest) {
        Resource resource = new Resource();
        resource.setName(resourceRequest.name());
        resource.setDescription(resourceRequest.description());
        resource.setAddress(resourceRequest.address());
        return repository.save(resource);
    }

    @Override
    @Transactional
    public Resource edit(Long id, ResourceRequest resourceRequest) {
        Resource resource = this.repository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Resource with id: " + id + " not found"));
        resource.setName(resourceRequest.name());
        resource.setDescription(resourceRequest.description());
        resource.setAddress(resourceRequest.address());
        return repository.save(resource);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Resource findById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Resource with id: "+id+"doesn't exist"));
    }

    @Override
    public Page<ResourceDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.repository.findAll(pageable)
                .map(resource -> new ResourceDTO(resource.getId(),resource.getName(), resource.getAddress(), resource.getDescription()));
    }

    @Override
    public List<ResourceServiceDTO> findAllResources(Long locationId, Long serviceId) {
        return this.repository
                .findResourceServiceProjectionByLocationIdAndService(locationId, serviceId)
                .stream().map(ResourceServiceProjection::toDTO)
                .toList();
    }
}
