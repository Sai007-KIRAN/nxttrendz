package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ProductJpaRepository;
import com.example.nxttrendz1.repository.ProductRepository;
// Write your code here

@Service
public class ProductJpaService implements ProductRepository {
    @Autowired
    private ProductJpaRepository pjr;

    @Override
    public ArrayList<Product> allProduct() {
        List<Product> productList = pjr.findAll();
        ArrayList<Product> productArray = new ArrayList<>(productList);
        return productArray;
    }

    @Override
    public Product eachProduct(int productId) {
        try {
            Product products = pjr.findById(productId).get();
            return products;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        pjr.save(product);
        return product;
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        try {
            Product update = pjr.findById(productId).get();
            if (product.getProductName() != null) {
                update.setProductName(product.getProductName());
            }
            if (product.getPrice() >= 0.0) {
                update.setPrice(product.getPrice());
            }
            pjr.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delete(int productId) {
        try {
            pjr.deleteById(productId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}