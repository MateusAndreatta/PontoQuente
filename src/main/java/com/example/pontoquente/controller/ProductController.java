package com.example.pontoquente.controller;


import com.example.pontoquente.model.Product;
import com.example.pontoquente.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Product>> getProducts() {
        try {
            List<Product> productList = service.getProducts();
            return ResponseEntity.ok(productList);
        }
        catch (Exception exception) {
            System.out.println("Erro ao listar produtos: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product,  @PathVariable Integer id) {
        try {
            Product updatedProduct = service.update(id, product);
            return ResponseEntity.ok(updatedProduct);
        }
        catch (Exception exception) {
            System.out.println("Erro ao atualizar o produto: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception exception) {
            System.out.println("Erro ao deletar o produto: " + exception.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
