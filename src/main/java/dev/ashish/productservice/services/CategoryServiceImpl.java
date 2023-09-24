package dev.ashish.productservice.services;

import dev.ashish.productservice.models.Category;
import dev.ashish.productservice.models.Product;
import dev.ashish.productservice.repositories.CategoryRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Category getCategory(String uuid) {
        Optional<Category> categoryOptional=categoryRepository.findById(UUID.fromString(uuid));
        if(categoryOptional.isEmpty()){
            return null;
        }
        Category category=categoryOptional.get();
        List<Product> products=category.getProducts();

        return  category;
    }

//    @Override
//    public List<String> getProductTitles(List<String> categoryUUIDs) {
//        return null;
//    }
}
