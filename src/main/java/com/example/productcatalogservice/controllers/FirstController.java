package com.example.productcatalogservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping
    public String welcome(){
        return "Welcome to First Controller";
    }
}
