package com.winterlee.bankaccount.controllers;

import com.winterlee.bankaccount.classes.BankAccount;

public class TestBankAccount {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount(50d, 100d);
		account1.display();
		account2.display();
		
		account1.depositChecking(123.50);
		account1.depositSavings(229.75);
		
		account2.withdrawChecking(60);
		account2.withdrawSavings(60);
		
		account1.display();
		account2.display();
		
		System.out.printf("Total balance at the bank: $%.2f", BankAccount.getTotalAmount());
		System.out.println("\nTotal acounts count: " + BankAccount.getTotalAccounts());
		
	}
}
