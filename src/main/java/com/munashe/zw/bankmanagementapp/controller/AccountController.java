package com.munashe.zw.bankmanagementapp.controller;

import com.munashe.zw.bankmanagementapp.entity.Account;
import com.munashe.zw.bankmanagementapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    @Autowired
    AccountService service;
    //create account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED).body
                (service.createAccount(account));
    }
    @GetMapping("/{accountNumber}")
    public Account getAccountById(@PathVariable Long accountNumber){
        return service.getAccountByNumber( accountNumber);
    }
    @GetMapping("/get-all")
    public List<Account>  getAccounts(){
        return service.getAllAccounts();

    }
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositMoney(@PathVariable Long accountNumber,@PathVariable Double amount){
        return service.depositAmount(accountNumber,amount);
    }
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawMoney(@PathVariable Long accountNumber,@PathVariable Double amount){
        return service.withdrawAmount(accountNumber,amount);
    }
    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity deleteAccount(@PathVariable Long accountNumber){
        service.closeAccount(accountNumber);
       return ResponseEntity.ok("Account closed");
    }

}
