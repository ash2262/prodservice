package dev.ashish.productservice.Controllers;

import dev.ashish.productservice.Exceptions.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProductControllerTest {

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
