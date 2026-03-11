package com.bank;

import com.bank.models.BankAccount;
import com.bank.services.BankService;
import com.bank.repository.AccountRepository;

public class Main {
    public static void main(String[] args){
//        System.out.print("bank system started");
        AccountRepository repository = new AccountRepository();
        BankService bankService = new BankService(repository);

        BankAccount account = bankService.createBankAccount("Pranjal", 1000);

        bankService.deposit(account.getAccountNumber(), 500);
        bankService.withdraw(account.getAccountNumber(), 200);

        System.out.println("Final Balance: " + repository.findByAccountNumber(account.getAccountNumber()).getBalance());
    }
}
