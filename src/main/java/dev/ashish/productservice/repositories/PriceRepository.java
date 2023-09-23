package dev.ashish.productservice.repositories;

import dev.ashish.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository
        extends JpaRepository<Price,Long> {
}
