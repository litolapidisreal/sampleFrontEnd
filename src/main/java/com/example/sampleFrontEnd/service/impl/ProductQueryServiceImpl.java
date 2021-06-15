package com.example.sampleFrontEnd.service.impl;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.repository.ProductRepository;
import com.example.sampleFrontEnd.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findIfAvailable(Boolean isAvailable) {
        return productRepository.findByIsAvailable(isAvailable);
    }

    @Override
    public List<Product> findByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}
