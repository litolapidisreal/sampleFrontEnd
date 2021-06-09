package com.example.sampleFrontEnd.repository;

import com.example.sampleFrontEnd.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsAvailable(boolean published);
    List<Product> findByTitle(String title);

}
