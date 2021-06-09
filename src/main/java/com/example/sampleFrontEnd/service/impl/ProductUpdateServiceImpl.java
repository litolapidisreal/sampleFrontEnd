package com.example.sampleFrontEnd.service.impl;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.repository.ProductRepository;
import com.example.sampleFrontEnd.service.ProductUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdateServiceImpl implements ProductUpdateService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Boolean save(Product product) {
        System.out.println(product.getDescription());
        productRepository.save(product);
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean delete() {
        productRepository.deleteAll();
        return true;
    }

}
