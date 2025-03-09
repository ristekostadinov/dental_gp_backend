package riste.kostadinov.graduation.project.repositories;

import riste.kostadinov.graduation.project.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
