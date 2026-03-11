package com.bank;

import com.bank.models.BankAccount;
import com.bank.services.BankService;
import com.bank.repository.AccountRepository;

public class Main {
    public static void main(String[] args){
//        System.out.print("bank system started");
        AccountRepository repository = new AccountRepository();
        BankService bankService = new BankService();

        BankAccount account = new BankAccount("12345", "Pranjal", 1000);

        repository.save(account);

        BankAccount retrieved = repository.findByAccountNumber("12345");

        bankService.deposit(retrieved, 500);
        bankService.withdraw(retrieved, 200);

        System.out.println("Final Balance: " + retrieved.getBalance());
    }
}
