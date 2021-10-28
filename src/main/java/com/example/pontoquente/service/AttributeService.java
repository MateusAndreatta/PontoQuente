package com.example.pontoquente.service;
import com.example.pontoquente.model.Attribute;
import com.example.pontoquente.repository.AttributesRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    public Set<Attribute> save(Set<Attribute> attributes) {
        Set<Attribute> retorno = new HashSet();
        for (Attribute attribute : attributes) {
            retorno.add(repository.save(attribute));
        }
        return  retorno;
    }
}
