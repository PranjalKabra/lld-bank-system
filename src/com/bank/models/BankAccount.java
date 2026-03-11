package com.bank.models;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolderName, double balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public String getAccountHolderName(){
        return this.accountHolderName;
    }
    public double getBalance(){
        return this.balance;
    }
    public void credit(double amount){
        this.balance += amount;
    }
    public void debit(double amount){
        this.balance -= amount;
    }
}
