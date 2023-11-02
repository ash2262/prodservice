package dev.ashish.productservice.Controllers;

import dev.ashish.productservice.Exceptions.NotFoundException;
import dev.ashish.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerWebMVCTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;

    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception{
        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());

//        mockMvc.perform(get("/products"))
        mockMvc.perform(get("/products"))
                .andExpect(status().is(404))
                .andExpect(content().string("[]"));

    }
}
