package com.bank.services;
import com.bank.models.BankAccount;
import com.bank.models.Transaction;
import com.bank.models.TransactionType;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import java.util.*;

public class BankService {
    private AccountRepository accRepository;
    private TransactionRepository transRepository;
    public BankService(AccountRepository accRepository, TransactionRepository transRepository){
        this.accRepository = accRepository;
        this.transRepository = transRepository;
    }
    public BankAccount createBankAccount(String accountHolderName, double balance){
        String accountNumber = UUID.randomUUID().toString();
        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);
        accRepository.save(account);
        TransactionType type = TransactionType.ACCOUNT_OPENED;
        Transaction t = new Transaction(type, balance);
        transRepository.addTransaction(accountNumber, t);
        return account;
    }
    public void  deposit(String accountNumber, double amount){
        BankAccount account = accRepository.findByAccountNumber(accountNumber);
        if(account == null){
            System.out.println("Account not found");
            return;
        }
        if(amount <= 0) {
            System.out.println("Invalid deposit amount");
            throw new IllegalArgumentException("invalid deposit amount");
        }
        account.credit(amount);
        TransactionType type = TransactionType.DEPOSIT;
        Transaction t = new Transaction(type, amount);
        transRepository.addTransaction(accountNumber, t);

    }
    public void withdraw(String accountNumber, double amount){
        BankAccount account = accRepository.findByAccountNumber(accountNumber);
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
        TransactionType type = TransactionType.WITHDRAW;
        Transaction t = new Transaction(type, amount);
        transRepository.addTransaction(accountNumber, t);
    }
    public void printTransactionHistory(String accountNumber){
        List<Transaction> list = transRepository.getTransactions(accountNumber);
        for(Transaction  t: list){
            System.out.println(t.getType() + " :: " +  t.getAmount());
        }
    }
}
