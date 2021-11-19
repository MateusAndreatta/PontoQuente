package com.example.pontoquente.service;

import com.example.pontoquente.model.Product;
import com.example.pontoquente.model.SellerAddress;
import com.example.pontoquente.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    private final SellerRepository repository;

    public SellerService(SellerRepository sellerRepository) {
        this.repository = sellerRepository;
    }

    public SellerAddress create(SellerAddress sellerAddress){
        return repository.save(sellerAddress);
    }
    
    public SellerAddress findById(long id){
        Optional<SellerAddress> byId = repository.findById(id);
        return byId.orElse(null);
    }
}
