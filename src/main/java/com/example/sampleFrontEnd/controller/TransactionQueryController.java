package com.example.sampleFrontEnd.controller;

import com.example.sampleFrontEnd.models.Transaction;
import com.example.sampleFrontEnd.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class TransactionQueryController {
    @Autowired
    TransactionQueryService transactionQueryService;
    @Autowired
    DataSamplerService dataSamplerService;
    @Autowired
    TransactionUpdateService transactionUpdateService;

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Transaction> transactions = new ArrayList<Transaction>();
             transactionQueryService.findAll().forEach(transactions::add);
            if (transactions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTutorialById(@PathVariable("id") long id) {
        Optional<Transaction> tutorialData = transactionQueryService.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/transactionsSampler/{id}")
    public ResponseEntity<List<Transaction>> createSampleData(@PathVariable("id") Integer id) {
        System.out.println(dataSamplerService.createDataTransaction(id));
        return new ResponseEntity<>(transactionQueryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {

        try {
            Boolean _tutorial = transactionUpdateService.save(transaction);
            return new ResponseEntity<>(transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/transactions")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Boolean> updateTutorial(@RequestBody Transaction transaction) {

        Optional<Transaction> tutorialData = transactionQueryService.findById(transaction.getId());

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(transactionUpdateService.save(transaction), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {

        try {
            transactionUpdateService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/transactions")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {

        try {
            transactionUpdateService.delete();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/transactions/datePublished")
    public ResponseEntity<List<Transaction>> findByPublished(@RequestHeader Date fromDate, @RequestHeader Date toDate) {

        try {
            List<Transaction> products = transactionQueryService.findByDate(fromDate, toDate);

            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}