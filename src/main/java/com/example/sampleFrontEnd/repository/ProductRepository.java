package com.example.sampleFrontEnd.repository;

import com.example.sampleFrontEnd.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsAvailable(boolean published);
    List<Product> findByTitle(String title);

}
