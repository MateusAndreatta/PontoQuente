package com.example.pontoquente.repository;
import com.example.pontoquente.model.Product;
import com.example.pontoquente.model.SellerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findFirstBySellerIdEquals(Long sellerId);
}