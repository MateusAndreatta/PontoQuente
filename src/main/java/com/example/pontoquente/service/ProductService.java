package com.example.pontoquente.service;

import com.example.pontoquente.model.Product;
import com.example.pontoquente.model.SellerAddress;
import com.example.pontoquente.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final SellerService sellerService;

    public ProductService(ProductRepository productRepository, SellerService sellerService) {
        this.repository = productRepository;
        this.sellerService = sellerService;
    }

    public Product create(Product product){
        product.setSite_id("PTQ");
        SellerAddress sellerAddress = findSellerAddressById(product.getSellerId());
        if (sellerAddress == null){ // Não encontrado no banco, cadastra conforme chegou na requisição
            sellerAddress = sellerService.create(product.getSeller_address());
        }

        product.setSeller_address(sellerAddress);
        return repository.save(product);
    }

    private SellerAddress findSellerAddressById(long id){
        Optional<Product> bySeller_id = repository.findFirstBySellerIdEquals(id);
        if(bySeller_id.isPresent()) {
            return bySeller_id.get().getSeller_address();
        }
        return null;
    }

    public Product update(Product product) {
        product.setSite_id("PTQ");
        SellerAddress sellerAddress = findSellerAddressById(product.getSellerId());
        if (sellerAddress == null){ // Não encontrado no banco, cadastra conforme chegou na requisição
            sellerAddress = sellerService.create(product.getSeller_address());
        }

        product.setSeller_address(sellerAddress);
        return repository.save(product);
    }
}
