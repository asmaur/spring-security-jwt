package com.wanubit.security.service;

import com.wanubit.security.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> list();
    Optional<Product> retrieve(Long id);
    Product create(Product product);
}
