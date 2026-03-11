package com.bank.services;
import com.bank.models.BankAccount;
import com.bank.models.Transaction;
import com.bank.models.TransactionType;
import com.bank.models.Customer;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.repository.TransactionRepository;
import java.util.*;

public class BankService {
    private AccountRepository accRepository;
    private TransactionRepository transRepository;
    private CustomerRepository customerRepo;
    public BankService(AccountRepository accRepository, TransactionRepository transRepository, CustomerRepository customerRepo){
        this.accRepository = accRepository;
        this.transRepository = transRepository;
        this.customerRepo = customerRepo;
    }
    private void recordTransaction(String accountNumber, TransactionType type, double amount, String relatedAccountNumber){
        Transaction t= new Transaction(type, amount, relatedAccountNumber);
        transRepository.addTransaction(accountNumber, t);
        return;
    }
    public String createBankAccount(String accountHolderName, double balance){
        String accountNumber = UUID.randomUUID().toString();
        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance);
        accRepository.save(account);
        recordTransaction(accountNumber, TransactionType.ACCOUNT_OPENED, balance, null);
        return accountNumber;
    }
    public void  deposit(String accountNumber, double amount){
        BankAccount account = accRepository.findByAccountNumber(accountNumber);
        if(account == null){
            throw new IllegalArgumentException("Account not found");
        }
        if(amount <= 0) {
            System.out.println("Invalid deposit amount");
            throw new IllegalArgumentException("invalid deposit amount");
        }
        account.credit(amount);
        recordTransaction(accountNumber, TransactionType.DEPOSIT, amount, null);

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
        recordTransaction(accountNumber, TransactionType.WITHDRAW, amount, null);
    }
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount){
        if(amount <=0){
            throw new IllegalArgumentException("acmount cannot be negative");
        }
        BankAccount from = accRepository.findByAccountNumber(fromAccountNumber);
        BankAccount to = accRepository.findByAccountNumber(toAccountNumber);
        if((from == null) || (to == null)){
            throw new IllegalArgumentException("Account not found");
        }
        if(from.getBalance() < amount){
            throw new IllegalArgumentException("Not enough balance to transfer this amount");
        }

        from.debit(amount);
        to.credit(amount);

        recordTransaction(fromAccountNumber, TransactionType.TRANSFER_OUT, amount, toAccountNumber);
        recordTransaction(toAccountNumber, TransactionType.TRANSFER_IN, amount, fromAccountNumber);

    }
    public void printTransactionHistory(String accountNumber){
        List<Transaction> list = transRepository.getTransactions(accountNumber);
        for(Transaction  t: list){
            if(t.getType() == TransactionType.TRANSFER_IN){
                System.out.println(t.getTimestamp() + " -> " + t.getType() + " :: " + t.getAmount() + " from " + t.getRelatedAccount());

            }
            else if(t.getType() == TransactionType.TRANSFER_OUT){
                System.out.println(t.getTimestamp() + " -> " + t.getType() + " :: " + t.getAmount() + " to " + t.getRelatedAccount());
            }
            else{
                System.out.println(t.getTimestamp() + " -> " + t.getType() + " :: " +  t.getAmount());
            }
        }
    }
    public double getBalance(String accountNumber){
        BankAccount acc = accRepository.findByAccountNumber(accountNumber);
        if(acc == null){
            throw new IllegalArgumentException("Please enter a valid account number");
        }
        return acc.getBalance();
    }
    public String createCustomer(String name){
        String customerId = UUID.randomUUID().toString();
        Customer customer = new Customer(name, customerId);
        this.customerRepo.save(customer);
        return customerId;
    }
    public String createAccount(String customerId, double balance){
//        System.out.println("Searching customer: " + customerId);
        Customer customer = this.customerRepo.findById(customerId);

        if(customer == null){
            throw new IllegalArgumentException("Nope, there doesn't exist such a customer");
        }
        String accountNumber = createBankAccount(customer.getName(), balance);
        customer.addAccount(accountNumber);
        return accountNumber;
    }
}
