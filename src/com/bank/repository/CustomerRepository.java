package com.bank.repository;
import com.bank.models.Customer;
import java.util.*;
public class CustomerRepository {
    private Map<String, Customer> customers = new HashMap<>();
    public void save(Customer customer){
        this.customers.put(customer.getCustomerId(), customer);
    }
    public Customer findById(String customerId){
        return this.customers.get(customerId);
    }
}
