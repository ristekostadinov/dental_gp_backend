package riste.kostadinov.graduation.project.services;

import org.springframework.data.domain.Page;
import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.ResourceDTO;
import riste.kostadinov.graduation.project.domains.dtos.ResourceRequest;
import riste.kostadinov.graduation.project.domains.dtos.ResourceServiceDTO;

import java.util.List;

public interface ResourceService {
    Resource save(ResourceRequest resourceRequest);
    Resource edit(Long id, ResourceRequest resourceRequest);
    void delete(Long id);
    Resource findById(Long id);
    Page<ResourceDTO> findAll(int page, int size);
    List<ResourceServiceDTO> findAllResources(Long locationId, Long serviceId);
}
