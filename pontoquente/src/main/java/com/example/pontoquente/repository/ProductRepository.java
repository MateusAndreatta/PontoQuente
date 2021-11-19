package com.example.pontoquente.repository;
import com.example.pontoquente.model.Product;
import com.example.pontoquente.model.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findFirstBySellerIdEquals(Long sellerId);
    @Query("SELECT p FROM Product p")
    List<ProductResponse> findAllProductResponse();
}