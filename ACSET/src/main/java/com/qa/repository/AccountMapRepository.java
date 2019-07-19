package com.qa.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.inject.Alternative;

import com.qa.domain.Account;
import util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private Map<Integer, Account> accountMap;

	private int count = 1;

	private JSONUtil json; 
	
	

	public AccountMapRepository() {
		super();
		this.accountMap = new HashMap<Integer, Account>();
		this.json = new JSONUtil();  
	}

	public String getAllAccounts() {
		return new JSONUtil().getJSONForObject(accountMap);
	}

	public String createAccount(String account) {
		Account toAdd = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.put(this.count++, toAdd);
		if (this.accountMap.containsValue(toAdd)) {
			return SUCCESS;
		} else {
			return FAILURE;  
		}
	}

	public String updateAccount(int accountNo, String account) {
		Account toUpdate = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.replace(accountNo, toUpdate);
		if (this.accountMap.containsValue(toUpdate)) {
			return SUCCESS;
		} else {
			return FAILURE;  
		}
	}

	public long cycleAccounts(String firstName) {
		return accountMap.values().stream().filter(a -> a.getFirstName().equals(firstName)).count();
	}

	
	public String deleteAccount(int accountNo) {
		if (!this.accountMap.containsKey(accountNo))
			this.accountMap.remove(accountNo);
		return SUCCESS;
	}

	@Override
	public List<Account> findAccountsByFirstName(String firstName) {
		return this.accountMap.values().stream().filter(a -> a.getFirstName().equals(firstName))
				.collect(Collectors.toList());    
	}
}
