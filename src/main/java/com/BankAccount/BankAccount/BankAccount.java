package com.BankAccount.BankAccount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

	 private String accountNumber;
	 private String pin;
	 private String accountHolder;
	 private double balance;
	 
	  private List<String> history = new ArrayList<>();

	public BankAccount(String accountNumber, String pin, String accountHolder, double initialBalance) {
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.accountHolder = accountHolder;
		this.balance = initialBalance;
	
		
		history.add(time() + "Account created. Initial Balance: " + initialBalance);
	}
	private String time() {
		return "[" + LocalDateTime.now() + "]";
		
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	  
	public boolean validate(String acc, String pin) {
		
       return this.accountNumber.equals(acc) && this.pin.equals(pin);
    		 }
	
	public void deposit(double amount) {
		if( amount <= 0) {
			System.out.println("Amount must be possitive.");
		}
		balance+= amount;
		history.add(time() + "Deposited:" + amount + ",new Balance" + balance );
        System.out.println("Deposite Successful!");
	}
	 // Withdraw
	 public void withdraw(double amount) {
		 if(amount <=0) {
			 System.out.println("Amount must be positive.");
		 }
		 
		 if(amount> balance) {
			 System.out.println("Insufficient balance!");
		 }
		 balance-= amount;
		 history.add(time () + "Withdraw: " + amount + ", New Balance :" + balance);
	     System.out.println("Withdraw successful!");
	 }
	 public double getBalance() {
		 return balance;
	 }
	
	 public void showHistory() {
		 System.out.println("\n--- Transaction History ---");
		 history.forEach(System.out::println);
	 }
	 
	 public String getAccountHolder() {
		 return accountHolder;
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
	  
	 
}
