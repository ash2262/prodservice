package dev.ashish.productservice.repositories;

import dev.ashish.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CategoryRepository extends JpaRepository<Category, Long> {
Optional<Category> findById(Long id);
    @Override
    List<Category> findAllById(Iterable<Long> uuids);
}
