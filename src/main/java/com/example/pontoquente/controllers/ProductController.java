package com.example.pontoquente.controllers;



import com.example.pontoquente.domain.model.ProductDTO;
import com.example.pontoquente.repository.ProductRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

        ProductDTO p1 = new ProductDTO();
        p1.setTitle("Produto A");
        p1.setQuantidade(3);
        p1.setPreco(334);
        ProductDTO p2 = new ProductDTO();
        p2.setTitle("Produto b");
        p2.setQuantidade(67);
        p2.setPreco(32);
        produtosMock.add(p1);
        produtosMock.add(p2);
    }

    ArrayList<ProductDTO> produtosMock = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody ProductDTO product) throws Exception {
        try {
            produtosMock.add(product);
            return ResponseEntity.ok().build();
        }
        catch (DataIntegrityViolationException exception) {
            throw new Exception("Erro ao cadastrar produto");
        }
    }
    @GetMapping
    public ArrayList<ProductDTO> relatorio(){
        return produtosMock;
    }

}
