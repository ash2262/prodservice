package dev.ashish.productservice.services;

import dev.ashish.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    public Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);
}
