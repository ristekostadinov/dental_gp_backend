package riste.kostadinov.graduation.project.services.impl;

import riste.kostadinov.graduation.project.domains.Category;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.CategoryRequest;
import riste.kostadinov.graduation.project.exceptions.CategoryNotFoundException;
import riste.kostadinov.graduation.project.repositories.CategoryRepository;
import riste.kostadinov.graduation.project.services.CategoryService;
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
