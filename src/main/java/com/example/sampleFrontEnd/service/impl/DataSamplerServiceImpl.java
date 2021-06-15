package com.example.sampleFrontEnd.service.impl;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.models.Transaction;
import com.example.sampleFrontEnd.repository.ProductRepository;
import com.example.sampleFrontEnd.repository.TransactionRepository;
import com.example.sampleFrontEnd.service.DataSamplerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class DataSamplerServiceImpl implements DataSamplerService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public String createData(Integer numberOfData) {
        List<Product> productList = new ArrayList<>();
        Random rd = new Random(); // creating Random object
        for(int i=0; i<numberOfData;i++) {
            Product sample = new Product();
            sample.setId(null);
            sample.setDescription("Description for test data " + i);
            sample.setPrice(rd.nextDouble()*10000);
            sample.setTitle("TESTDATA_" + i);
            sample.setProductType("Raw Materials");
            sample.setAvailable(rd.nextBoolean());
            sample.setOutdated(false);
            productList.add(sample);
            System.out.println(i + " :" + productList.size());
        }
        productRepository.saveAll(productList);
        return "There are " + numberOfData + " in the DB";
    }

    @Override
    public String createDataTransaction(Integer numberOfData) {
        List<Transaction> transactionList = new ArrayList<>();
        for(int i=0; i<numberOfData;i++) {
            Random rd = new Random(); // creating Random object
            Transaction sample = new Transaction();
            sample.setComment("Sample");
            sample.setDateClosing(null);
            sample.setDateCreated(new Date(System.currentTimeMillis()- (long) rd.nextDouble()*100000));
            sample.setDateUpdated(null);
            sample.setProductId(1L);
            sample.setQnty(34L);
            sample.setSale(rd.nextBoolean());
            sample.setShip(rd.nextBoolean());
            sample.setTotalPrice(1200.00);
            sample.setUserId("1");
            transactionList.add(sample);
            System.out.println(i + " :" + transactionList.size());
        }
        transactionRepository.saveAll(transactionList);
        return "There are " + numberOfData + " in the DB";
    }
}
