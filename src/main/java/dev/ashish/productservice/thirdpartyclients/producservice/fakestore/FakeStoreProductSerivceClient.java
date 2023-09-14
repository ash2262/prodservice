package dev.ashish.productservice.thirdpartyclients.producservice.fakestore;

import dev.ashish.productservice.Exceptions.NotFoundException;
import dev.ashish.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Wrapper over FakeStore API

@Service
public class FakeStoreProductSerivceClient {
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;

    private String specificProductRequestUrl ;
    private String productRequestsBaseUrl ;

    public FakeStoreProductSerivceClient (RestTemplateBuilder restTemplateBuilder,
                                          @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                          @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath){
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsBaseUrl  = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
    }


    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=new RestTemplateBuilder().build();
        ResponseEntity<FakeStoreProductDto> response=
                restTemplate.postForEntity(productRequestsBaseUrl,product,FakeStoreProductDto.class);

        return  response.getBody();
    }
    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        // FakeStoreProductService fakeStoreProductService=new FakeStoreProductService();
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response= restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        if(fakeStoreProductDto==null){
            throw  new NotFoundException("Product with id: "+id+"doesn't exists");
        }

        // response.getStatusCode();
        return  fakeStoreProductDto;

        // return  new Product();

    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> response=
                restTemplate.getForEntity(productRequestsBaseUrl,FakeStoreProductDto[].class);

        List<GenericProductDto> answer=new ArrayList<>();



        return  Arrays.stream(response.getBody()).toList();
        //return null;
    }

    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response= restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);


        //restTemplate.delete(specificProductrequestURL);
        return response.getBody();
    }
}
