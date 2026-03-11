package com.bank.models;
import java.time.*;

public class Transaction {
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;
    public Transaction(TransactionType type, double amount){
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }
    public TransactionType getType(){
        return this.type;
    }
    public double getAmount(){
        return this.amount;
    }
    public LocalDateTime getTimestamp(){
        return this.timestamp;
    }

}
