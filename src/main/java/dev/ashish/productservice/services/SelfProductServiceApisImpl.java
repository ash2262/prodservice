package dev.ashish.productservice.services;

import dev.ashish.productservice.Exceptions.NotFoundException;
import dev.ashish.productservice.dtos.GenericProductDto;
import dev.ashish.productservice.dtos.Productdto;
import dev.ashish.productservice.models.Price;
import dev.ashish.productservice.models.Product;
import dev.ashish.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;


@Primary
    @Service("selfProductServiceImpl")
    public class SelfProductServiceApisImpl implements ProductServiceApis {
        private ProductRepository productRepository;

        public SelfProductServiceApisImpl(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }


    @Override
    public Productdto addonProduct(Productdto productDto) {
        Product product=convertToProduct(productDto);
        productRepository.save(product);
        return convertProductToDBProductDto(product);
    }
    @Transactional
    @Override
    public Productdto updateProduct(Productdto productDto, Long id)  throws NotFoundException{
        // Retrieve the existing product by ID
        Product product = this.productRepository.findProductById(id);

        if (product!=null) {
            Product existingProduct = new Product();
            existingProduct.setId(product.getId());

            // Update the properties of the existing product based on the DTO

            existingProduct.setTitle(productDto.getTitle());
            existingProduct.setDescription(productDto.getDescription());

            // Update the product's price
//            Price price = existingProduct.getPrice();
//            if (price == null) {
//                price = new Price();
//            }
            //price.setPrice(productDto.getPrice());
            //price.setCurrency(productDto.getCurrency());
            //existingProduct.setPrice(price);

            existingProduct.setImage(productDto.getImage());

            //CategoryDto categoryDto = productDto.getCategory();
            //Category category = null;

            // Check if the category already exists by name
//            if (categoryDto != null && categoryDto.getName() != null) {
//                category = categoryRepository.findByName(categoryDto.getName());
//            }

            // If the category doesn't exist, create a new one
//            if (category == null) {
//                category = new Category();
//                category.setName(categoryDto.getName());
//            }

            // Add the product to the category and set the category for the product
//            category.getProducts().add(existingProduct);
//            existingProduct.setCategory(category);

            // Save the updated product
            existingProduct = productRepository.save(existingProduct);

            return convertProductToDBProductDto(existingProduct);
        }
        else
            throw new NotFoundException("product with  id "+id+" not found");
    }
    @Override
    public Productdto getProductById(Long id) throws NotFoundException {
       Product   product = productRepository.findProductById(id);
        if (product != null) {
            return convertProductToDBProductDto(product);
        }
        else{
            throw  new NotFoundException("Product with id "+id+" not found");
        }
    }

    @Override
    public List<Productdto> getAllProducts() {
        List<Product> products=productRepository.findAllProducts();
        return products.stream().map(this::convertProductToDBProductDto).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllCategories() {
        return productRepository.getAllProductCategory();
    }


    @Transactional
    @Override
    public List<Productdto> getProductsByCategory(String category) throws NotFoundException{
        List<Product> productList = productRepository.getAllProductByCategory(category);
        if( productList == null || productList.isEmpty()){
            throw new NotFoundException(" category "+category+" not found");
        }
        return productList.stream().map(this::convertProductToDBProductDto).collect(Collectors.toList());

    }


    @Override
    public Productdto deleteProduct(Long id) throws NotFoundException {
        Product product = productRepository.findProductById(id);
        if(product != null){
            productRepository.delete(product);
            return convertProductToDBProductDto(product);
        }
        else throw new NotFoundException("Product with  id "+id+" not found");
    }



    private Product convertToProduct(Productdto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        Price price = new Price();
        //price.setPrice(productDto.getPrice());
      //  price.setCurrency(productDto.getCurrency());
        product.setPrice(price);
        product.setImage(productDto.getImage());
//        CategoryDto categoryDto = productDto.getCategory();
//        Category category = null;
//        if (categoryDto != null && categoryDto.getName() != null) {
//
//            category = categoryRepository.findByName(categoryDto.getName());
//        }
//        if (category == null) {
//            category = new Category();
//            category.setName(categoryDto.getName());
//        }
//        category.getProducts().add(product);
//        product.setCategory(category);
//
//        product.setCategory(category);
        return product;
    }

        private Productdto convertProductToDBProductDto(Product product) {
            Productdto productdto = new Productdto();

            productdto.setId(product.getId());
            productdto.setTitle(product.getTitle());
            productdto.setDescription(product.getDescription());
            productdto.setImage(product.getImage());
            return productdto;
        }


}

