package dev.ashish.productservice.Controllers;
import dev.ashish.productservice.Exceptions.NotFoundException;
import dev.ashish.productservice.dtos.GenericProductDto;
import dev.ashish.productservice.services.ProductService;
import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



@SpringBootTest
public class ProductControllerTest {

    @MockBean
    private ProductService productService;
    @Autowired
    private ProductController productController;
@Test
    void throwsExceptionWhenProductDoesNotExist() throws NotFoundException {
        when(
            productService.getProductById(any(Long.class))
        )
                .thenReturn(null);
        assertThrows(NotFoundException.class,()->productController.getProductById(123L));
    }

    @Test
    void returnsSameProductAsServiceWhenProductExists()  throws NotFoundException {
        GenericProductDto genericProductDto=new GenericProductDto();
        when(
                productService.getProductById(any(Long.class))
        )
                .thenReturn(genericProductDto);
        assertEquals(genericProductDto.getPrice(),productController.getProductById(123L));
    }
    @Test
    void testOnePlusOneEqualsTrue(){
        System.out.println("It is true");
        //assertEquals (11 , 1+1,"one plus one is not coming to be 11");


    }

    @Test

    void additionShouldBeCorrect(){
        //assert(-1 + -1 == -2);
     //   assertTrue(-1+1==2,"adding 2 negatives is not correct");
//
//        assertTrue(-1 + 0 == -1, "adding a negative and a zero is giving wrong answer");
//
//        assertTrue(-1 + 1 == 0);

        assert 1 + 0 == 1;

        assert 1 + 1 == 2;

    }
}
