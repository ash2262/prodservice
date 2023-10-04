package dev.ashish.productservice.services;

import dev.ashish.productservice.models.Category;
import dev.ashish.productservice.models.Product;
import dev.ashish.productservice.repositories.CategoryRepository;
import dev.ashish.productservice.repositories.ProductRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository){
        this.categoryRepository=categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public Category getCategory(Long id) {
        Optional<Category> categoryOptional=categoryRepository.findById(id);
        if(categoryOptional.isEmpty()){
            return null;
        }
        Category category=categoryOptional.get();
        List<Product> products=category.getProducts();

        return  category;
    }

    @Override
    public List<String> getProductTitles(List<Long> categoryIDs) {
        List<Long> ids = new ArrayList<>();

        for (Long uuid: categoryIDs) {
            ids.add(uuid);
        }

        List<Category> categories = categoryRepository.findAllById(ids);

        /*TODO:Go through N+1 problem video after 2:20:00*/
        List<Product> products = productRepository.findAllByCategoryIn(categories);

        List<String> titles = new ArrayList<>();

        for (Product p: products) {
            titles.add(p.getTitle());
        }

        return titles;


    }
}
