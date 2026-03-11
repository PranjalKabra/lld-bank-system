package com.bank;

import com.bank.models.BankAccount;
import com.bank.services.BankService;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;

public class Main {
    public static void main(String[] args){
//        System.out.print("bank system started");
        AccountRepository accountRepository = new AccountRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        BankService bankService = new BankService(accountRepository, transactionRepository);

        String acc1 = bankService.createBankAccount("Alice",1000);
        String acc2 = bankService.createBankAccount("Bob",500);

        bankService.deposit(acc1,200);

        bankService.transfer(acc1,acc2,300);

        System.out.println(bankService.getBalance(acc1));
        System.out.println(bankService.getBalance(acc2));

        bankService.printTransactionHistory(acc1);
        bankService.printTransactionHistory(acc2);
    }
}
