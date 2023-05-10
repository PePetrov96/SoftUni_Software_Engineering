package com.example.accountsystem;

import com.example.accountsystem.model.Account;
import com.example.accountsystem.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountSystemApplicationTests {

	@Test
	void withdraw_works() {
		User user = new User("petrov1", 26);
		Account account = new Account(new BigDecimal("25000"));

		user.addAccount(account);

		BigDecimal money1 = new BigDecimal("20000");

		account.withdrawBalance(money1);

		BigDecimal actualBalance = account.getBalance();
		BigDecimal expectedBalance = new BigDecimal("5000");

		assertEquals(expectedBalance, actualBalance, "Account balance should be 5000");
	}

	@Test
	void deposit_works() {
		User user = new User("petrov2", 26);
		Account account = new Account(new BigDecimal("5000"));

		account.depositBalance(new BigDecimal("5000"));

		BigDecimal actualBalance2 = account.getBalance();
		BigDecimal expectedBalance2 = new BigDecimal("10000");

		assertEquals(expectedBalance2, actualBalance2, "Account balance should be 10000");
	}

}
