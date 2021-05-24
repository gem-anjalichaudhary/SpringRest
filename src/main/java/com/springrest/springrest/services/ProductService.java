package com.springrest.springrest.services;

import com.springrest.springrest.entities.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getProducts();

    public Product getProduct(String productId);

    public List<Product> addProduct(Product product);

    public List<Product> updateProduct(Product product);

    List<Product> deleteProduct(String productId);
}
