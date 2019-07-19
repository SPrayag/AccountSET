package com.qa.service;

import java.util.List;

import javax.inject.Inject;
import com.qa.domain.Account;

import com.qa.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;

	@Override
	public String getAllAccounts() {
		return this.repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		return this.repo.createAccount(account);
	}

	@Override
	public String deleteAccount(int accountId) {
		return this.repo.deleteAccount(accountId);
	}

	@Override
	public String updateAccount(int accountId, String account) {
		return this.repo.updateAccount(accountId, account);
	}

	@Override
	public List<Account> findAccountsByFirstName(String firstName) {
		return this.repo.findAccountsByFirstName(firstName);  
	}
}
