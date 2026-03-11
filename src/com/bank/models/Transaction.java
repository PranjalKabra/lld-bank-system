package com.bank.models;

public class Transaction {
    private TransactionType type;
    private double amount;
    public Transaction(TransactionType type, double amount){
        this.type = type;
        this.amount = amount;
    }
    public TransactionType getType(){
        return this.type;
    }
    public double getAmount(){
        return this.amount;
    }

}
