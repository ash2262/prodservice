package dev.ashish.productservice.Controllers;

import dev.ashish.productservice.Exceptions.ExceptionDto;
import dev.ashish.productservice.Exceptions.NotFoundException;
import dev.ashish.productservice.dtos.GenericProductDto;
import dev.ashish.productservice.dtos.Productdto;
import dev.ashish.productservice.services.ProductService;
import dev.ashish.productservice.services.ProductServiceApis;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")

public class ProductController {
    private ProductServiceApis productService;

    public ProductController(@Qualifier("selfProductServiceImpl") ProductServiceApis productService){
        this.productService=productService;
    }

    @GetMapping
    public List<Productdto> getAllProducts(){
       return productService.getAllProducts();

    }
    @GetMapping("{id}")
    public Productdto getProductById(@PathVariable("id") Long id) throws  NotFoundException{
        return  productService.getProductById(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Productdto>  deleteProductById(@PathVariable("id") Long id) throws NotFoundException {
        return  new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
      // return  null;
    }
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> HandleNotFoundException(NotFoundException notFoundException){
        //System.out.println("Not found exception happened");
        return  new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND,notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }


    @PostMapping
    @PutMapping
    public Productdto createProduct(@RequestBody Productdto product){


        //return "Created product with id: "+ product.getTitle();
        //return productService.createProduct(product);
        return productService.addonProduct(product);

    }
    @PutMapping("{id}")
    public Productdto updateProductById(@PathVariable("id") Long id,@RequestBody Productdto product) throws  NotFoundException{
      //if(product!=null)
        return  productService.updateProduct(product,id);

    }
}
