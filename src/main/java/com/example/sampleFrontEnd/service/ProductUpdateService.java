package com.example.sampleFrontEnd.service;

import com.example.sampleFrontEnd.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductUpdateService {
    Boolean save(Product product);
    Boolean delete(Long id);
    Boolean delete();
}
