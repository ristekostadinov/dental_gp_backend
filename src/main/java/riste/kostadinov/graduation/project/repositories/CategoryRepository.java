package riste.kostadinov.graduation.project.repositories;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.Query;
import riste.kostadinov.graduation.project.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import riste.kostadinov.graduation.project.domains.dtos.CategoryDTO;

import java.awt.print.Pageable;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
