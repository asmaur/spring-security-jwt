package com.wanubit.security.controller;

import com.wanubit.security.domain.Product;
import com.wanubit.security.dto.ProductDTO;
import com.wanubit.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> list(){
        var products = service.list();
        return new ResponseEntity<>(products.stream().map(
                product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build()
        ).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto){
        var newProduct = service.create(
                Product.builder()
                        .name(dto.getName())
                        .price(dto.getPrice())
                        .build()
        );
        return new ResponseEntity<>(
                ProductDTO.builder()
                        .id(newProduct.getId())
                        .name(newProduct.getName())
                        .price(newProduct.getPrice())
                        .build(), HttpStatus.CREATED
        );
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> retrieve(@PathVariable Long id){
        try{
            Optional<Product> product = service.retrieve(id);
            return product.map(p -> new ResponseEntity<>(
                    ProductDTO.builder()
                            .id(p.getId())
                            .name(p.getName())
                            .price(p.getPrice())
                            .build(), HttpStatus.OK
            )).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
