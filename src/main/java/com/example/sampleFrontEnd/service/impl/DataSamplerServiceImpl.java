package com.example.sampleFrontEnd.service.impl;

import com.example.sampleFrontEnd.models.Product;
import com.example.sampleFrontEnd.repository.ProductRepository;
import com.example.sampleFrontEnd.service.DataSamplerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DataSamplerServiceImpl implements DataSamplerService {
    @Autowired
    ProductRepository productRepository;

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
}
