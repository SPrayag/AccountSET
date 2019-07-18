package com.qa.repository;

import javax.enterprise.inject.Alternative;
  
@Alternative
public interface AccountRepository {
	
	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";

	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(int accountNo);
	String updateAccount(int accountNo, String account);

}
