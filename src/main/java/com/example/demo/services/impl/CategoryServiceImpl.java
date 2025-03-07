package com.example.demo.services.impl;

import com.example.demo.domains.Category;
import com.example.demo.domains.dtos.CategoryDTO;
import com.example.demo.domains.dtos.CategoryRequest;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Transactional
    @Override
    public Category save(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.name());
        return this.repository.save(category);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return List.of();
    }

    @Override
    public Category findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with id "+id+" doesn't exist"));
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Transactional
    @Override
    public Category edit(Long id, CategoryRequest categoryRequest) {
        Category category = this.findById(id);
        category.setName(categoryRequest.name());
        return this.repository.save(category);
    }
}
