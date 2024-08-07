package com.example.productcatalogservice.clients.fakeStore;

import com.example.productcatalogservice.dtos.FakeStoreProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class FakeStoreApiClient {
    private RestTemplateBuilder restTemplateBuilder;


    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public FakeStoreProductDto getProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class, productId).getBody();
    }
    public FakeStoreProductDto[] getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForEntity("https://fakestoreapi.com/products/",
                FakeStoreProductDto[].class).getBody();

    }
    public FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProductDtoReq) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreProductDtoReq, FakeStoreProductDto.class).getBody();
    }


    public FakeStoreProductDto replaceProduct(Long productId, FakeStoreProductDto fakeStoreProductDtoReq) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = postForEntity("https://fakestoreapi.com/products/{id}", fakeStoreProductDtoReq, FakeStoreProductDto.class, productId);
        return fakeStoreProductDtoResponseEntity.getBody();
    }


    public FakeStoreProductDto deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = deleteForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
        return fakeStoreProductDtoResponseEntity.getBody();

    }
    private <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }
    private  <T> ResponseEntity<T> deleteForEntity(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.DELETE, requestCallback, responseExtractor, uriVariables);
    }

}
