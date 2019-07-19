package com.qa.rest;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.qa.service.AccountService;

@Path("/account")
public class AccountController {

	@Inject
	private AccountService service;
	
	@GET
	@Path("/getAll")
	public String getAllAccounts() {
		return this.service.getAllAccounts();
	}

	@POST
	@Path("/createAccount")
	public String createAccount(String account) {
		return this.service.createAccount(account);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int accountId) {
		return this.service.deleteAccount(accountId);
	}

	@POST
	@Path("/update/{id}")
	public String updateAccount(@PathParam("id") int accountId, String account) {
		return this.service.updateAccount(accountId, account);
	}
		
/*	@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)  
	public String createAccount(String account) {
	return this.service.createAccount(account);	 
	}	
	
	@POST
	@Path("/updateUser")
	@Consumes(MediaType.APPLICATION_JSON) 
	public String updateAccount(int accountId, String account) {
		return this.service.updateAccount(accountId, account);  
	}
	*/
}
