package com.bank.repository;
import com.bank.models.Transaction;

import java.util.*;

public class TransactionRepository {
    private Map<String, List<Transaction>>  transactions= new HashMap<>();
    public void addTransaction(String accountNumber, Transaction transaction){
        transactions.putIfAbsent(accountNumber, new ArrayList<>());
        transactions.get(accountNumber).add(transaction);
    }

    public List<Transaction> getTransactions(String accountNumber){
        return transactions.get(accountNumber);
    }

}
