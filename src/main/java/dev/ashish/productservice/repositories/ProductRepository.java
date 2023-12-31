package dev.ashish.productservice.repositories;

import dev.ashish.productservice.models.Category;
import dev.ashish.productservice.models.Category;

import dev.ashish.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//import java.util.UUID;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    Product findByTitleEquals(String title);

     Product findByTitleEqualsAndPrice_Price(String title, double price);

     List<Product> findAllByPrice_Currency(String currency);

     @Query(CustomQueries.FIND_PROD_BY_ID)
     Product  findProductById(Long id);

     @Query(value = CustomQueries.FIND_ALL_PRODUCT_BY_CATEGORY)
     List<Product> getAllProductByCategory(String categoryName);
     @Query(value = CustomQueries.FIND_ALL_PRODUCT)
     List<Product> findAllProducts();

     @Query(nativeQuery = true, value = CustomQueries.GET_ALL_PRODUCT_CATEGORY)
     List<String> getAllProductCategory();

     List<Product> findAllByCategoryIn(List<Category> categories);
     long countAllByPrice_Currency(String currency);

     @Query(value = CustomQueries.FIND_ALL_BY_TITLE,nativeQuery = true)
     List<Product> findAllByTitle(String ashish);

}
