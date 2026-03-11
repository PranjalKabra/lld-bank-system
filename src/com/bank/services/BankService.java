package com.bank.services;
import com.bank.models.BankAccount;

public class BankService {
    public void  deposit(BankAccount account, double amount){
        if(amount <= 0){
            System.out.println("Invalid deposit amount");
        }
        double newBalance = account.getBalance() + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + newBalance);

    }
}
