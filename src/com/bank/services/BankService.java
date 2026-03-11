package com.bank.services;
import com.bank.models.BankAccount;
import com.bank.repository.AccountRepository;

public class BankService {
    private AccountRepository repository;
    public BankService(AccountRepository repository){
        this.repository = repository;
    }
    public void  deposit(String accountNumber, double amount){
        BankAccount account = repository.findByAccountNumber(accountNumber);
        if(account == null){
            System.out.println("Account not found");
            return;
        }
        if(amount <= 0) {
            System.out.println("Invalid deposit amount");
            throw new IllegalArgumentException("invalid deposit amount");
        }
        account.credit(amount);

    }
    public void withdraw(String accountNumber, double amount){
        BankAccount account = repository.findByAccountNumber(accountNumber);
        if(account == null){
            System.out.println("account not found");
            return;
        }
        if(amount <= 0){
            System.out.println("invalid withdraw amount");
            throw new IllegalArgumentException("invalid withdraw amount");
        }
        if(account.getBalance() < amount){
            System.out.println("do not have much balance");
            throw new IllegalArgumentException("not enough balance");
        }
        account.debit(amount);

    }
}
