package com.example.sampleFrontEnd.service.impl;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.models.Transaction;
import com.example.sampleFrontEnd.repository.TransactionRepository;
import com.example.sampleFrontEnd.service.TransactionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findByDate(Date dateFrom, Date dateTo) {
        return transactionRepository.findByDateCreatedBetween(dateFrom, dateTo);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

}
