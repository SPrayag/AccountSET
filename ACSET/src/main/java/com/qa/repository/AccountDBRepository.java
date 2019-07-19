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


@Transactional(value = TxType.SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
  
	  
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
  
	@Inject
	private JSONUtil json;
  
	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a", Account.class);
		return json.getJSONForObject(query.getResultList());
	}  

	@Override
	public List<Account> findAccountsByFirstName(String firstName) {
		TypedQuery<Account> query = this.em.createQuery("SELECT a FROM Account a WHERE a.firstName = :firstName", Account.class);
		query.setParameter("firstName", firstName);
		return query.getResultList();    
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		Account anAccount = json.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return SUCCESS;  
	}  

	@Override
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

	@Override
	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int accountNo) {
		em.remove(em.find(Account.class, accountNo));
		return SUCCESS;  
	}  

}
