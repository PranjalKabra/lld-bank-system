package com.bank.repository;
import com.bank.models.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    private Map<String, BankAccount> accounts = new HashMap<>();
    public void save(BankAccount account){
        accounts.put(account.getAccountNumber(), account);
    }
    public BankAccount findByAccountNumber(String accountNumber){
        return accounts.get(accountNumber);
    }
}
