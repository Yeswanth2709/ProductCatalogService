package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public List<Product> getAllProducts() {
        return null;
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId ) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(100000D);
        product.setDescription("This is a test");
        return product;
    }
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }
}
