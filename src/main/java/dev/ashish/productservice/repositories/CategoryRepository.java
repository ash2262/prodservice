package dev.ashish.productservice.repositories;

import dev.ashish.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
Optional<Category> findById(UUID uuid);
}
