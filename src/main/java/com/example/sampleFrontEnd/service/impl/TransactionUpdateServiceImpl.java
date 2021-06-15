package com.example.sampleFrontEnd.service.impl;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.models.Transaction;
import com.example.sampleFrontEnd.repository.TransactionRepository;
import com.example.sampleFrontEnd.service.TransactionUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionUpdateServiceImpl implements TransactionUpdateService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Boolean save(Transaction transaction) {
        System.out.println(transaction);
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        transactionRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean delete() {
        transactionRepository.deleteAll();
        return true;
    }

}
