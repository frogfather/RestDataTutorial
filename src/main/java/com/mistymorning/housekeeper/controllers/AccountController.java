package com.mistymorning.housekeeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Account;
import com.mistymorning.housekeeper.services.api.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
		@RequestMapping("/budgets/{budgetId}/accounts")
		public List<Account> getAllAccounts(@PathVariable Long budgetId) {
			return accountService.getAllAccounts(budgetId);
		}
		
		@RequestMapping("/budgets/{budgetId}/accounts/{id}")
		public Account getAccount(@PathVariable Long budgetId, @PathVariable Long id) {
			return accountService.getAccount(budgetId, id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/budgets/{budgetId}/accounts")
		public Account addAccount(@PathVariable Long budgetId, @RequestBody Account account) {
			return accountService.addAccount(budgetId, account);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/budgets/{budgetId}/accounts/{accountId}")
		public Account updateAccount(@PathVariable Long budgetId, @PathVariable Long accountId, @RequestBody Account account) {
			return accountService.updateAccount(budgetId, accountId, account);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/budgets/{budgetId}/accounts/{accountId}") 
		public void deleteAccount(@PathVariable Long budgetId, @PathVariable Long accountId) 
		{
			accountService.deleteAccount(accountId);
		}
	
}