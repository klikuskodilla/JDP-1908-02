package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.entity.ProductEntity;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    public Optional<ProductEntity> getProduct(final Long id) {
        return repository.findById(id);
    }

    public ProductEntity saveProduct(final ProductEntity productEntity) {
        return repository.save(productEntity);
    }

    public void deleteProduct(final Long id) {
        repository.deleteById(id);
    }
}
