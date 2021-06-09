package com.example.sampleFrontEnd.service;

import com.example.sampleFrontEnd.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {
    List<Product> findIfAvailable (Boolean isAvailable);
    List<Product> findByTitle (String title);
    List<Product> findAll ();
    Optional<Product> findById (Long id);


}
