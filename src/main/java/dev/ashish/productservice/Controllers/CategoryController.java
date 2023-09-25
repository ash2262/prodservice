package dev.ashish.productservice.Controllers;

import dev.ashish.productservice.dtos.GetProductTitlesRequestDto;
import dev.ashish.productservice.dtos.Productdto;
import dev.ashish.productservice.models.Category;
import dev.ashish.productservice.models.Product;
import dev.ashish.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/{uuid}")
    public List<Productdto> getCategory(@PathVariable("uuid") String uuid){
    //public String getCategory(String uuid){
        String message="Reached the request";

        List<Product> products=categoryService.getCategory(uuid).getProducts();
        List<Productdto> productdtos=new ArrayList<>();

        for(Product product:products){
            Productdto productdto=new Productdto();
            productdto.setDescription(product.getDescription());
            productdto.setTitle(product.getTitle());
            productdto.setImage(product.getImage());
            productdto.setPrice(product.getPrice());

            productdtos.add(productdto);
        }

        return productdtos;
       // return message;
    }

    @GetMapping("/titles/")
    public  List<String> getProductTitles(@RequestBody GetProductTitlesRequestDto requestDto){
        List<String> uuids=requestDto.getUuids();
        return categoryService.getProductTitles(uuids);
    }
}
