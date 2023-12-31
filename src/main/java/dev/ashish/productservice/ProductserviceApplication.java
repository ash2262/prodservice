package dev.ashish.productservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.ashish.productservice.inheritancedemo.joinedtable.Mentor;
import dev.ashish.productservice.inheritancedemo.joinedtable.MentorRepository;
import dev.ashish.productservice.inheritancedemo.joinedtable.User;
import dev.ashish.productservice.inheritancedemo.joinedtable.UserRepository;
import dev.ashish.productservice.models.Category;
import dev.ashish.productservice.models.Price;
import dev.ashish.productservice.models.Product;
import dev.ashish.productservice.repositories.CategoryRepository;
import dev.ashish.productservice.repositories.PriceRepository;
import dev.ashish.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;

import org.hibernate.query.UnknownSqlResultSetMappingException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import java.awt.geom.PathIterator;
import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication {//implements CommandLineRunner {


//    private MentorRepository mentorRepository;
//
//
//    private  UserRepository userRepository;
//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    public  ProductserviceApplication(    @Qualifier("jt_mr") MentorRepository mentorRepository, @Qualifier("jt_ur") UserRepository userRepository,
//                                          ProductRepository productRepository,
//                                          CategoryRepository categoryRepository,
//                                          PriceRepository priceRepository){
//        this.mentorRepository=mentorRepository;
//        this.userRepository=userRepository;
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//    }


    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
////        Mentor mentor=new Mentor();
////        mentor.setName("Naman");;
////        mentor.setEmail("Naman@scaler.com");
////        mentor.setAverageRating(4.65);
////        mentorRepository.save(mentor);
////
////        User user=new User();
////        user.setName("Sarath");
////        user.setEmail("sarathcool@yopmail.com");
////        userRepository.save(user);
//
//        Category category=new Category();
//        category.setName("Apple Devices");
//       // Category savedCategory= categoryRepository.save(category);
//
//        Price price=new Price("Rupees",10);
//        //Price savedPrice= priceRepository.save(price);
//
//        Product product=new Product();
//        product.setTitle("iPhone 15 pro");
//        product.setDescription("The best iphone Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//        productRepository.save(product);
//
//        productRepository.deleteById(UUID.fromString("206aca95-43c8-4386-a252-924f9e145f16"));
//        System.out.println(productRepository.countAllByPrice_Currency("Rupee"));
//
//        List<Product> products= productRepository.findAllByPrice_Currency("Rupee");
//
////        Category category1=  categoryRepository.findById(UUID.fromString("2a27723d-b5fb-4b1b-8df5-bd2f8fe36e5f")).get();
////
////        System.out.println("Category name is"+category1.getName());
////        System.out.println("Printing all products in the category");
//
//       // Thread.sleep(1000);
//
//        List<Product> products1=productRepository.findAllByTitle("iPhone 15 pro");
//
//        System.out.println("Fetching category 0b7aea01-3b15-42b4-8552-9706abdb8db2");
//        Thread.sleep(1000);
//        Optional< Category> category1Optional=categoryRepository.findById(UUID.fromString("0b7aea01-3b15-42b4-8552-9706abdb8db2"));
//        Category category1=category1Optional.get();
//        System.out.println("Fetching products for category");
//        Thread.sleep(1000);
//        category1.getProducts();
//
//    }

}
