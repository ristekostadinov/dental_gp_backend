package com.example.demo.services.impl;

import com.example.demo.domains.Resource;
import com.example.demo.domains.dtos.ResourceRequest;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.ResourceRepository;
import com.example.demo.services.ResourceService;
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
        return repository.save(resource);
    }

    @Override
    @Transactional
    public Resource edit(Long id, ResourceRequest resourceRequest) {
        Resource resource = this.repository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Resource with id: " + id + " not found"));
        resource.setName(resourceRequest.name());
        return repository.save(resource);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Resource findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Resource with id: "+id+"doesn't exist"));
    }

    @Override
    public List<Resource> findAll() {
        return this.repository.findAll();
    }
}
