package com.example.sampleFrontEnd.service;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.models.Transaction;

public interface TransactionUpdateService {
    Boolean save(Transaction product);
    Boolean delete(Long id);
    Boolean delete();
}
