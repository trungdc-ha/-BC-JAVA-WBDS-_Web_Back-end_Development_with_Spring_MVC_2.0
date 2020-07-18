package com.codegym.shopping_cart.service;

import com.codegym.shopping_cart.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void remove(Long id);
}
