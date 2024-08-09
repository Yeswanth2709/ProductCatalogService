package com.example.productcatalogservice.services;

import com.example.productcatalogservice.clients.fakeStore.FakeStoreApiClient;
import com.example.productcatalogservice.dtos.FakeStoreProductDto;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements IProductService {
    private FakeStoreApiClient fakeStoreApiClient;

    public FakeStoreProductService(FakeStoreApiClient fakeStoreApiClient) {
        this.fakeStoreApiClient = fakeStoreApiClient;
    }


    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreApiClient.getAllProducts();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(getProduct(fakeStoreProductDto));
        }
        return products;
    }
    @Override
    public Product getProduct(Long productId){
        FakeStoreProductDto fakeStoreProductDto = fakeStoreApiClient.getProduct(productId);
        return getProduct(fakeStoreProductDto);
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDtoReq = getFakeStoreProductDto(product);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreApiClient.createProduct(fakeStoreProductDtoReq);
        return getProduct(fakeStoreProductDto);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        FakeStoreProductDto fakeStoreProductDtoReq = getFakeStoreProductDto(product);
        FakeStoreProductDto fakeStoreProductDto  = fakeStoreApiClient.replaceProduct(productId,fakeStoreProductDtoReq);
        return getProduct(fakeStoreProductDto);
    }

    @Override
    public Product deleteProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreApiClient.deleteProduct(productId);
        return getProduct(fakeStoreProductDto);

    }


    private Product getProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setName(fakeStoreProductDto.getTitle());
        product.setImageUrl(fakeStoreProductDto.getImage());
        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
    private FakeStoreProductDto getFakeStoreProductDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setPrice(product.getPrice());
        return fakeStoreProductDto;
    }
}
