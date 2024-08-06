package com.example.productcatalogservice.services;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getProduct(Long productId);

    Product createProduct(ProductDto productDto);
}
