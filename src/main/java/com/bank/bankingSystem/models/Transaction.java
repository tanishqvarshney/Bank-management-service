package com.bank.bankingSystem.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter

@NoArgsConstructor
@ToString
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String sender;
    String receiver;
    int amount;
    public Transaction(String sender, String receiver, int amount)
    {
        this.amount=amount;
        this.receiver=receiver;
        this.sender=sender;
    }

}
