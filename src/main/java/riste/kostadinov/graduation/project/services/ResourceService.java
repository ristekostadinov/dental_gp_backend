package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Resource;
import riste.kostadinov.graduation.project.domains.dtos.ResourceDTO;
import riste.kostadinov.graduation.project.domains.dtos.ResourceRequest;

import java.util.List;

public interface ResourceService {
    Resource save(ResourceRequest resourceRequest);
    Resource edit(Long id, ResourceRequest resourceRequest);
    void delete(Long id);
    Resource findById(Long id);
    List<ResourceDTO> findAll();
}
