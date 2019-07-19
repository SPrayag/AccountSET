package com.qa.service;

import java.util.List;

import com.qa.domain.Account;

public interface AccountService {

	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(int accountNo);
	String updateAccount(int accountNo, String account);
	
	List<Account> findAccountsByFirstName(String firstName);
	  
}
