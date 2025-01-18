package com.munashe.zw.bankmanagementapp.service;

import com.munashe.zw.bankmanagementapp.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountByNumber(Long accountNumber);
    public List<Account> getAllAccounts();
    public Account depositAmount(Long accountNumber,Double amount);
    public Account withdrawAmount(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);

}
