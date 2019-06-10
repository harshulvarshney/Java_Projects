package com.java.thread.deadlock;

public class Account {
	
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public static void transfer(Account acc1, Account acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}

}
