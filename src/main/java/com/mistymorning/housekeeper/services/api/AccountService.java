package com.mistymorning.housekeeper.services.api;


import java.util.List;

import com.mistymorning.housekeeper.classes.Account;

public interface AccountService {
	
	public List<Account> getAllAccounts(Long budgetId);
	
	public Account getAccount(Long budgetId, Long id);
	
	public Account addAccount(Long budgetId, Account account);
	
	public Account updateAccount(Long budgetId, Account account);
	
	public void deleteAccount(Long budgetId, Long accountId);
	
}