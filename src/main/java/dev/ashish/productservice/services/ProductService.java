package dev.ashish.productservice.services;

import dev.ashish.productservice.Exceptions.NotFoundException;
import dev.ashish.productservice.dtos.GenericProductDto;
import dev.ashish.productservice.dtos.Productdto;

import java.util.List;

public interface ProductService {
    GenericProductDto  createProduct(GenericProductDto product);

    GenericProductDto  getProductById(Long id) throws NotFoundException;
    List<GenericProductDto > getAllProducts();
    GenericProductDto  deleteProduct(Long id);
}
