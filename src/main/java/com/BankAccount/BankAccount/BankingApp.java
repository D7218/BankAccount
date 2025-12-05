package com.BankAccount.BankAccount;

import java.util.Optional;
import java.util.Scanner;

public class BankingApp 
{
    public static void main( String[] args )
    {
       Scanner sc = new Scanner(System.in);
       BankService bankService = new BankService();
       
       // add multiple accounts
       bankService.addAccount(new BankAccount("1001", "1111", "Om Dubbe", 5000));
       bankService.addAccount(new BankAccount("1002", "2222", "Rahul", 7000));
       bankService.addAccount(new BankAccount("1003", "3333", "Sita", 3000));
 
       bankService.addAccount(new BankAccount("1011", "1444", "AMER", 15000));
       bankService.addAccount(new BankAccount("1012", "2333", "Mohan", 27000));
       bankService.addAccount(new BankAccount("1013", "3222", "Satish", 53000));
       
       mainLoop:
    	   while(true) {
         System.out.print("Enter Account Number:");
        String acc = sc.nextLine();
        
        System.out.print("Enter PIN:");
        String pin = sc.nextLine();
        
        Optional<BankAccount> loggedInAccount = bankService.login(acc, pin);
        
        if(!loggedInAccount.isPresent()) {
        	System.out.println("Invalid account number or PIN");
        	return;
        }
        BankAccount user  = loggedInAccount.get();
        System.out.println("\nLogin Successful! WelCome," + user.getAccountHolder());
        	
        while(true) {
        	System.out.println("\n----- Menu -----");
        	System.err.println("1. Deposit");
        	System.out.println("2. Withdraw");
        	System.out.println("3. check Balance");
        	System.out.println("4.Transaction History");
        	System.out.println("5. Logout");
        	System.out.println("Enter choice: ");
        	
        	int choice = sc.nextInt();
        	
        	switch(choice) {
        	case 1: 
        		System.out.println("Enter amount to deposit:");
        		double dep = sc.nextDouble();
        		user.deposit(dep);
        		break;
        		
        	case 2:
        		System.out.println("Enter amount to Withdraw: ");
        		double wit = sc.nextDouble();
        		user.withdraw(wit);
        		break;
        		
        	case 3:
        		System.out.println("Current Balance: "+ user.getBalance());
        		
        	case 4:
        		user.showHistory();
        		break;
        		
        	case 5:
        		System.out.println("Logged out. Returning to login page...\n");
        		sc.nextLine();
        		continue mainLoop;
//        		System.exit(0);
//        		
        		default:
        		
        			System.out.println("Invalid option. try again");
        	}
        }
    }
}
}
