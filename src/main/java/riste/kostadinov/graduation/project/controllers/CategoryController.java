package riste.kostadinov.graduation.project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import riste.kostadinov.graduation.project.domains.Category;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;
import riste.kostadinov.graduation.project.domains.dtos.CategoryRequest;
import riste.kostadinov.graduation.project.services.CategoryService;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping()
    public ResponseEntity<Page<CategoryDTO>> getAllCategories(@RequestParam int page, @RequestParam int size) {
        try{
            Page<CategoryDTO> categories = this.service.findAll(page, size);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return new ResponseEntity<>(this.service.save(categoryRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        try{
            Category category = this.service.findById(id);
            return new ResponseEntity<>(new CategoryDTO(category.getId(), category.getName()), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        try{
            Category category = this.service.findById(id);
            this.service.edit(id, categoryRequest);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        this.service.delete(id);
    }
}
