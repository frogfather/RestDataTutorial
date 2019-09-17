package com.mistymorning.housekeeper.controllers;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Account;
import com.mistymorning.housekeeper.services.api.AccountService;

@RestController
@RequestMapping("/budgets/{budgetId}")
public class AccountController extends AbstractController{
	
	@Autowired
	private AccountService accountService;
	
		@RequestMapping("/accounts")
		public Response getAllAccounts(@PathVariable Long budgetId) {
			return buildResponse( true, accountService.getAllAccounts(budgetId));
		}
		
		@RequestMapping("/accounts/{id}")
		public Response getAccount(@PathVariable Long budgetId, @PathVariable Long id) {
			return buildResponse( true, accountService.getAccount(budgetId, id));
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/accounts")
		public Response addAccount(@PathVariable Long budgetId, @RequestBody Account account) {
			return buildResponse( true, accountService.addAccount(budgetId, account));
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/accounts/{accountId}")
		public Response updateAccount(@PathVariable Long budgetId, @PathVariable Long accountId, @RequestBody Account account) {
			return buildResponse( true, accountService.updateAccount(budgetId, accountId, account));
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{accountId}") 
		public void deleteAccount(@PathVariable Long budgetId, @PathVariable Long accountId) 
		{
			accountService.deleteAccount(accountId);
		}
	
}