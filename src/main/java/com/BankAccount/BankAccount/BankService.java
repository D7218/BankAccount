package com.BankAccount.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankService {

	 private List<BankAccount> accounts= new ArrayList<>(); 
	 
//	  public void addAccount(BankAccount account)
//	  {
//		  accounts.add(account);
//		  }
	  
	  // find account using java 8 optional + Stream
	  public Optional<BankAccount> login(String accNumber, String pin){
		  return accounts.stream()
				  .filter(acc -> acc.validate(accNumber, pin))
				  .findFirst();
	  }

	public void addAccount(BankAccount account) {
		accounts.add(account);
		
	}
	  }

