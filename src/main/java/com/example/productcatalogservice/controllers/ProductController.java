package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId ) {
        try {
            if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("Invalid product id");
            }
            Product product = productService.getProduct(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public Product createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }
    @PutMapping("{id}")
    public ProductDto updateProduct(@PathVariable("id") Long productId,@RequestBody ProductDto productDto) {
        return productDto;
    }
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {

    }
}
