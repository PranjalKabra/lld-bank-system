package com.bank;

import com.bank.models.BankAccount;
import com.bank.services.BankService;

public class Main {
    public static void main(String[] args){
//        System.out.print("bank system started");
        BankAccount account = new BankAccount("12345", "Pranjal", 1000);

        BankService bankService = new BankService();

        bankService.deposit(account, 500);
        bankService.withdraw(account, 300);
    }
}
