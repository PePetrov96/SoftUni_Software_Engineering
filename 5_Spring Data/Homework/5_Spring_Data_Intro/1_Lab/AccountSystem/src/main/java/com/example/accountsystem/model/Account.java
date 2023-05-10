package com.example.accountsystem.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private BigDecimal balance;

    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    public Account(BigDecimal balance) {
       setBalance(balance);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidParameterException("Must have a positive balance");
        }
        this.balance = balance;
    }

    public void depositBalance(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) <= 0) { //check if the transferred sum is a positive amount
            throw new InvalidParameterException("You need to transfer a positive balance");
        }

        this.balance = getBalance().add(money);
    }
    public void withdrawBalance(BigDecimal balance) {
        if (balance.compareTo(this.balance) > 0) { //check if the account has enough money
            throw new InvalidParameterException("Account does not have enough money");
        }

        this.balance = getBalance().subtract(balance);
    }
}