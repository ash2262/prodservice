package dev.ashish.productservice.thirdpartyclients.producservice.fakestore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeStoreProductSerivceClientTest {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Test
    void testNonExistingProductReturnsNull(){
        //        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response =
//                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
//
//        FakeStoreProductDto fakeStoreProductDto = response.getBody();
//
//        assertNull(fakeStoreProductDto);

    }

}