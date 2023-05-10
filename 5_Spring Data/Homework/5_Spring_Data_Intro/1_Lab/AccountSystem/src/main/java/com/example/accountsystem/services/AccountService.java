package com.example.accountsystem.services;

import com.example.accountsystem.model.Account;

import java.math.BigDecimal;

public interface AccountService {
    void registerAccount(Account account);

    void withdrawMoney(BigDecimal amount, Long id);

    void depositMoney(BigDecimal amount, Long id);

    void transferMoney(Long accountFrom, Long accountTo, BigDecimal amount);
}