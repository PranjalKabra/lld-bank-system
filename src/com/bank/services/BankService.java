package com.bank.services;
import com.bank.models.BankAccount;

public class BankService {
    public void  deposit(BankAccount account, double amount){
        if(amount <= 0){
            System.out.println("Invalid deposit amount");
            throw new IllegalArgumentException("invalid deposit amount");
        }
        double newBalance = account.getBalance() + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + newBalance);
        account.credit(amount);

    }
    public void withdraw(BankAccount account, double amount){
        if(amount <= 0){
            System.out.println("invalid withdraw amount");
            throw new IllegalArgumentException("invalid withdraw amount");
        }
        if(account.getBalance() < amount){
            System.out.println("do not have much balance");
            throw new IllegalArgumentException("not enough balance");
        }
        double newBalance = account.getBalance() - amount;
        System.out.println("Withdrawn: " + amount);
        System.out.println("Remaining Balance: " + newBalance);
        account.debit(amount);

    }
}
