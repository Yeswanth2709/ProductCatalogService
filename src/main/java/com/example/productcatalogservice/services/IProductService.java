package com.example.productcatalogservice.services;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getProduct(Long productId);

    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);
    Product deleteProduct(Long productId);
}
