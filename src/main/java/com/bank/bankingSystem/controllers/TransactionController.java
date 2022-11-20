package com.bank.bankingSystem.controllers;

import com.bank.bankingSystem.models.Transaction;
import com.bank.bankingSystem.models.User;
import com.bank.bankingSystem.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
public class TransactionController {


    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transaction/get/all")
    public List<Transaction> GetUserData(String name) {
        List<Transaction> allData = transactionRepository.findAll();
        return allData;
    }

}
