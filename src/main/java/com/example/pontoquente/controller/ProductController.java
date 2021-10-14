package com.example.pontoquente.controller;


import com.example.pontoquente.model.Product;
import com.example.pontoquente.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        try {
            Product newProduct = service.create(product);
            return ResponseEntity.ok(newProduct);
        }
        catch (Exception exception) {
            System.out.println("Erro ao cadastrar o produto: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
        try {
            Product newProduct = service.update(product);
            return ResponseEntity.ok(newProduct);
        }
        catch (Exception exception) {
            System.out.println("Erro ao atualizar o produto: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
