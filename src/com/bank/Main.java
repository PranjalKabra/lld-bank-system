package com.bank;

import com.bank.models.BankAccount;
import com.bank.services.BankService;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.repository.CustomerRepository;

public class Main {
    public static void main(String[] args){
//        System.out.print("bank system started");
        CustomerRepository customerRepo = new CustomerRepository();
        AccountRepository accountRepo = new AccountRepository();
        TransactionRepository transactionRepo = new TransactionRepository();

        BankService bankService = new BankService(accountRepo, transactionRepo, customerRepo);

        String customerId = bankService.createCustomer("Alice");
        System.out.println("customer id for alice " + customerId);
//        System.out.println(bankService.);

        String acc1 = bankService.createAccount(customerId,1000);
        String acc2 = bankService.createAccount(customerId,500);

        bankService.deposit(acc1,200);

        bankService.transfer(acc1,acc2,300);

        System.out.println(bankService.getBalance(acc1));
        System.out.println(bankService.getBalance(acc2));

        bankService.printTransactionHistory(acc1);
        bankService.printTransactionHistory(acc2);
    }
}
