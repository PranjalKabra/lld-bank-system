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

        BankAccount account = bankService.createBankAccount("Pranjal", 1000);

        String accNo = account.getAccountNumber();

        bankService.deposit(accNo, 500);
        bankService.withdraw(accNo, 200);

        bankService.printTransactionHistory(accNo);
    }
}
