package com.example.pontoquente.repository;

import com.example.pontoquente.model.Attribute;
import com.example.pontoquente.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttributesRepository extends JpaRepository<Attribute, Long> {
}
