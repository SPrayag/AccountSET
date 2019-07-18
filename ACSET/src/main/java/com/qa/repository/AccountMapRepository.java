package com.qa.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.domain.Account;

import util.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	private int count = 1;

	private JSONUtil json = new JSONUtil();

	
	public String getAllAccounts() {
		return new JSONUtil().getJSONForObject(accountMap);
	}

	public String createAccount(String account) {
		Account toAdd = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.put(this.count++, toAdd);
		if (this.accountMap.containsValue(toAdd)) {
			return SUCCESS;
		} else {
			return "Failed to add account";
		}
	}

	public String updateAccount(int accountNo, String account) {
		Account toUpdate = this.json.getObjectForJSON(account, Account.class);
		this.accountMap.replace(accountNo, toUpdate);
		if (this.accountMap.containsValue(toUpdate)) {
			return FAILURE;
		} else {
			return "Failed to add account";
		}
	}

	public long cycleAccounts(String firstName) {
		return accountMap.values().stream().filter(a -> a.getFirstName().equals(firstName)).count();
	}

	public String deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		return null;
	}    
}
