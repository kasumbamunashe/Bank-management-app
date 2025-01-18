package com.munashe.zw.bankmanagementapp.repository;

import com.munashe.zw.bankmanagementapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account,Long> {
}
