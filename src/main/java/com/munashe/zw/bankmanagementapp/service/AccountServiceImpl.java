package com.munashe.zw.bankmanagementapp.service;

import com.munashe.zw.bankmanagementapp.entity.Account;
import com.munashe.zw.bankmanagementapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository repository;
    @Override
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account getAccountByNumber(Long accountNumber) {
      Optional<Account> account= repository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account not found");
        }
        return account.get();
    }

    @Override
    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
     Optional<Account> account=  repository.findById(accountNumber);
     if(account.isEmpty()){
         throw new RuntimeException("Account not found");
     }
     Account accountPresent = account.get();
     Double totalBalance=  accountPresent.getAccountBalance()+amount;
     accountPresent.setAccountBalance(totalBalance);
     repository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account> account=  repository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account not found");
        }
        Account accountPresent = account.get();
        Double newBalance = accountPresent.getAccountBalance()-amount;
        accountPresent.setAccountBalance(newBalance);
        repository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {
       getAccountByNumber(accountNumber);
       repository.deleteById(accountNumber);
    }
}
