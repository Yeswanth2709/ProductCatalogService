package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return null;
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId ) {
        return productService.getProduct(productId);
    }
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }
    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable("id") Long productId,@RequestBody ProductDto productDto) {
        return productDto;
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {

    }
}
