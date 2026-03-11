package com.bank.models;
import java.time.*;

public class Transaction {
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;
    private String relatedAccount;
    public Transaction(TransactionType type, double amount, String relatedAccount){
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
