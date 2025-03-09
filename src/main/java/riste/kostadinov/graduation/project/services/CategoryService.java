package riste.kostadinov.graduation.project.services;

import riste.kostadinov.graduation.project.domains.Category;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.CategoryRequest;

import java.util.List;

public interface CategoryService {
    Category save(CategoryRequest categoryRequest);
    List<CategoryDTO> findAll();
    Category findById(Long id);
    void delete(Long id);
    Category edit(Long id, CategoryRequest categoryRequest);
}
