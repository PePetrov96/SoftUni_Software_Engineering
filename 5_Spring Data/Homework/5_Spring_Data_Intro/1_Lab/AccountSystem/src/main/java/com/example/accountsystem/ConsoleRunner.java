package com.example.accountsystem;

import com.example.accountsystem.model.Account;
import com.example.accountsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.accountsystem.services.AccountService;
import com.example.accountsystem.services.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;

    private final AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    @Transactional
    public void run(String... args) {
        //Create User and Accounts
        User user = new User("Peter", 25);
        Account account1 = new Account(new BigDecimal("25000"));
        Account account2 = new Account(new BigDecimal("2000"));

        //Register User
        userService.registerUser(user);

        //Register Accounts
        accountService.registerAccount(account1);
        accountService.registerAccount(account2);

        //Add the Accounts to the User
        user.addAccount(account1);
        user.addAccount(account2);

        //Withdraw money from account1 - left with 5_000.00
        accountService.withdrawMoney(new BigDecimal("20000"), account1.getId());

        //Deposit money from account1 - left with 35_000.00
        accountService.depositMoney(new BigDecimal("30000"), account1.getId());

        //Transfer money from account1 to account2 - account 1 left with 25_000.00, account 2 left with 12_000.00
        accountService.transferMoney(account1.getId(), account2.getId(), new BigDecimal("10000"));
    }
}
