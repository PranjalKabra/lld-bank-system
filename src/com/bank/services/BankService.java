package com.bank.services;
import com.bank.models.BankAccount;

import java.awt.image.BandCombineOp;

public class BankService {
    public void  deposit(BankAccount account, double amount){
        if(amount <= 0){
            System.out.println("Invalid deposit amount");
        }
        double newBalance = account.getBalance() + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + newBalance);

    }
    public void withdraw(BankAccount account, double amount){
        if(amount <= 0){
            System.out.println("invalid withdraw amount");
            return;
        }
        if(account.getBalance() < amount){
            System.out.println("do not have much balance");
            return;
        }
        double newBalance = account.getBalance() - amount;
        System.out.println("Withdrawn: " + amount);
        System.out.println("Remaining Balance: " + newBalance);
    }
}
