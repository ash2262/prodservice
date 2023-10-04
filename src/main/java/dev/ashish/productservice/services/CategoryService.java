package dev.ashish.productservice.services;

import dev.ashish.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    public Category getCategory(Long id);
    List<String> getProductTitles(List<Long> categoryIDs);
}
