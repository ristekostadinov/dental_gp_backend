package com.example.demo.services;

import com.example.demo.domains.Resource;
import com.example.demo.domains.dtos.ResourceRequest;

import java.util.List;

public interface ResourceService {
    Resource save(ResourceRequest resourceRequest);
    Resource edit(Long id, ResourceRequest resourceRequest);
    void delete(Long id);
    Resource findById(Long id);
    List<Resource> findAll();
}
