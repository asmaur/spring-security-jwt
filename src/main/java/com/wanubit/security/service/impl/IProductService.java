package com.wanubit.security.service.impl;

import com.wanubit.security.domain.Product;
import com.wanubit.security.repository.ProductRepository;
import com.wanubit.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IProductService implements ProductService {
    @Autowired
    ProductRepository repository;


    @Override
    public List<Product> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> retrieve(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }
}
