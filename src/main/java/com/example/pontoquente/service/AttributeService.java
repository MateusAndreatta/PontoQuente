package com.example.pontoquente.service;
import com.example.pontoquente.model.Attribute;
import com.example.pontoquente.repository.AttributesRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AttributeService {

    private final AttributesRepository repository;

    public AttributeService(AttributesRepository repository) {
        this.repository = repository;
    }

    public void deleteAll(Set<Attribute> attributes){
        for (Attribute attribute : attributes) {
            repository.deleteById(attribute.getId());
        }
    }
}
