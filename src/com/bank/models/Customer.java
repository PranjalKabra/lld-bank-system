package com.bank.models;
import java.util.*;

public class Customer {
    private String customerId;
    private String name;
    private List<String> accountNumbers;

    public Customer(String name, String customerId){
        this.name = name;
        this.customerId = customerId;
        this.accountNumbers = new ArrayList<>();
    }
    public void addAccount(String accountNumber){
        this.accountNumbers.add(accountNumber);
    }
    public String getCustomerId(){
        return this.customerId;
    }
    public String getName(){
        return this.name;
    }
    public List<String> getAccountNumbers(){
        return this.accountNumbers;
    }

}
