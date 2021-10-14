package com.example.pontoquente.repository;

import com.example.pontoquente.model.SellerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerAddress, Long> {
}
