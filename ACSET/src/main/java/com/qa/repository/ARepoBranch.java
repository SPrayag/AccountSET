package com.qa.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.domain.Account;
import util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class ARepoBranch {

	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
  
	@Inject  
	private JSONUtil json;

	public List<Account> getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.accountNo DESC", Account.class);
		return query.getResultList();
	}

	public List<Account> findAnAccount() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.firstName DESC", Account.class);
		return query.getResultList();
	}

	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		Account anAccount = json.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return "{\"message\": \"account sucessfully added\"}";  
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int accountId, String account) {
		Account newAccount = this.json.getObjectForJSON(account, Account.class);
		Account existing = this.em.find(Account.class, accountId);
		existing.setAccountNo(newAccount.getAccountNo()); 
		existing.setFirstName(newAccount.getFirstName());
		existing.setId(newAccount.getId());
		existing.setLastName(newAccount.getLastName());
		this.em.persist(existing);
		return null;  
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(long id) {
		em.remove(em.find(Account.class, id));
		return "{\"message\": \"deleted account sucessfully\"}";
	}

}
