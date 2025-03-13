package riste.kostadinov.graduation.project.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@Slf4j
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
    public Page<CategoryDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CategoryDTO> categories = this.repository
                .findAll(pageable)
                .map(category-> new CategoryDTO(category.getId(), category.getName()));
        log.info(categories.toString());
        return categories;
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
        Category category = this.repository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id "+id+" doesn't exist"));
        category.setName(categoryRequest.name());
        return this.repository.save(category);
    }
}
