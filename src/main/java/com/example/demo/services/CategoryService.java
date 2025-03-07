package com.example.demo.services;

import com.example.demo.domains.Category;
import com.example.demo.domains.dtos.CategoryDTO;
import com.example.demo.domains.dtos.CategoryRequest;

import java.util.List;

public interface CategoryService {
    Category save(CategoryRequest categoryRequest);
    List<CategoryDTO> findAll();
    Category findById(Long id);
    void delete(Long id);
    Category edit(Long id, CategoryRequest categoryRequest);
}
