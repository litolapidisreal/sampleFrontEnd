package com.example.sampleFrontEnd.service;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.models.Transaction;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionQueryService {
    List<Transaction> findByDate(Date dateFrom, Date dateTo);
    List<Transaction> findAll();
    Optional<Transaction> findById(Long id);


}
