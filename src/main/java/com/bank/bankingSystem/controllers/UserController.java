package com.bank.bankingSystem.controllers;

import com.bank.bankingSystem.models.Transaction;
import com.bank.bankingSystem.models.User;
import com.bank.bankingSystem.repositories.TransactionRepository;
import com.bank.bankingSystem.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransactionRepository transactionRepository;


    @PostMapping("/user/add")
    public User addUser(@RequestBody User user)
    {

        log.info(user.getName());
        log.info(String.valueOf(user));
        userRepository.save(user);
        return user;
    }


    @GetMapping("/user/get/all")
    public List<User> GetUserData(String name) {
        List<User> allData = userRepository.findAll();
        return allData;
    }

    @GetMapping("/update/{id1}/{balance}/{name}")
    public String UpdateBalance(@PathVariable("id1") int id1, @PathVariable("balance") int balance, @PathVariable("name") String
            name) {

       Optional<User> senderUser=userRepository.findById((long) id1);
       String sender;

         User user = senderUser.get();
         sender=user.getName();
         user.setBalance(user.getBalance()-balance);
         userRepository.save(user);

       User receiverUser=userRepository.findByName(name);
       receiverUser.setBalance(receiverUser.getBalance()+balance);
       userRepository.save(receiverUser);


       //for adding object in transaction table
        //log.info(String.format("%s %s %d", sender, name, balance));
        log.info("Worling");
        Transaction newTransaction =new Transaction(sender,name,balance);
           transactionRepository.save(newTransaction);
     return "succes";


    }
}