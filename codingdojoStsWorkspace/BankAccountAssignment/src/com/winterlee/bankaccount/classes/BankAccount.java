package com.winterlee.bankaccount.classes;

public class BankAccount {
	private double checkingBalance;
	private double savingsBalance;
	public static int numberOfAccounts;
	public static double totalAmount;
	
	public BankAccount() {
		numberOfAccounts++;
		System.out.println("A new account has been created.");
	}
	public BankAccount(double checkingBalance, double savingsBalance) {
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		numberOfAccounts++;
		totalAmount += checkingBalance + savingsBalance;
		System.out.println("A new account has been created.");
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	public void display() {
		System.out.printf("Checking Balance: $%.2f", checkingBalance);
		System.out.printf("\nSavings Balance: $%.2f", savingsBalance);
		System.out.println("\n-------------------------");
	}
	
	public void depositChecking(double amount) {
		this.checkingBalance += amount;
		totalAmount += amount;
		System.out.println("Deposit complete.");
	}
	public void depositSavings(double amount) {
		this.savingsBalance += amount;
		totalAmount += amount;
		System.out.println("Deposit complete.");
	}
	
	public void withdrawChecking(double amount) {
		if (checkingBalance <= 0 || checkingBalance < amount) {
			System.out.println("You have insufficient funds.");
		}
		else {
			checkingBalance -= amount;
			totalAmount -= amount;
			System.out.println("Withdrawal complete.");
		}
	}
	public void withdrawSavings(double amount) {
		if (savingsBalance <= 0 || savingsBalance < amount) {
			System.out.println("You have insufficient funds.");
		}
		else {
			savingsBalance -= amount;
			totalAmount -= amount;
			System.out.println("Withdrawal complete.");
		}
	}
	
	public static double getTotalAmount() {
		return totalAmount;
	}
	
	public static int getTotalAccounts() {
		return numberOfAccounts;
	}
	
}
