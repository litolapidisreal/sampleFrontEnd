package com.example.sampleFrontEnd.service;

import com.example.sampleFrontEnd.models.Product;

public interface ProductUpdateService {
    Boolean save(Product product);
    Boolean delete(Long id);
    Boolean delete();
}
