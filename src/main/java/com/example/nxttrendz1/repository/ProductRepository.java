package com.example.nxttrendz1.repository;

import java.util.ArrayList;
import com.example.nxttrendz1.model.Product;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository {
    ArrayList<Product> allProduct();

    Product eachProduct(int productId);

    Product addProduct(Product product);

    Product updateProduct(int productId, Product product);

    void delete(int productId);
}