package dev.ashish.productservice.services;

import dev.ashish.productservice.Exceptions.NotFoundException;
import dev.ashish.productservice.dtos.GenericProductDto;
import dev.ashish.productservice.dtos.Productdto;

import java.util.List;

public interface ProductServiceApis {
     Productdto getProductById(String id) throws NotFoundException;
     List<String> getAllCategories();

     Productdto addonProduct(Productdto productDto);
     List<Productdto> getProductsByCategory(String category) throws NotFoundException;

     List<Productdto> getAllProducts();
     Productdto updateProduct(Productdto productDto , String id) throws NotFoundException;

     Productdto deleteProduct(String id) throws NotFoundException;
}
