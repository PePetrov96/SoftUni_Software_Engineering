package com.example.accountsystem.services;

import com.example.accountsystem.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.accountsystem.repositories.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void registerAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    @Transactional
    public void withdrawMoney(BigDecimal money, Long id) {
        Account account = this.accountRepository.findAccountById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.withdrawBalance(money);
        this.accountRepository.save(account);
    }

    @Override
    @Transactional
    public void depositMoney(BigDecimal money, Long id) {
        Account account = this.accountRepository.findAccountById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.depositBalance(money);
        this.accountRepository.save(account);
    }

    @Override
    @Transactional
    public void transferMoney(Long accountFrom, Long accountTo, BigDecimal amount) {
        Account fromAccount = accountRepository.findAccountById(accountFrom)
                .orElseThrow(() -> new RuntimeException("Account from which to withdraw not found"));

        Account toAccount = accountRepository.findAccountById(accountTo)
                .orElseThrow(() -> new RuntimeException("Account to which to deposit not found"));

        fromAccount.withdrawBalance(amount);
        this.accountRepository.save(fromAccount);

        toAccount.depositBalance(amount);
        this.accountRepository.save(toAccount);
    }
}