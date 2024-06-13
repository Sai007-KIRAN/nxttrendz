package com.example.nxttrendz1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.service.ProductJpaService;

// Write your code here

@RestController
public class ProductController {

    @Autowired
    private ProductJpaService pjs;

    @GetMapping("/products")
    public ArrayList<Product> allProduct() {
        return pjs.allProduct();
    }

    @GetMapping("/products/{productId}")
    public Product eachProduct(@PathVariable("productId") int productId) {
        return pjs.eachProduct(productId);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return pjs.addProduct(product);
    }

    @PutMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return pjs.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void delete(@PathVariable("productId") int productId) {
        pjs.delete(productId);
    }
}