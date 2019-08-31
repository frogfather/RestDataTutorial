package com.mistymorning.housekeeper.services.api;


import java.util.List;

import com.mistymorning.housekeeper.classes.Account;

public interface AccountService {
	
	public List<Account> getAllAccounts(Long budgetId);
	
	public Account getAccount(Long budgetId, Long accountId);
	
	public Account addAccount(Long budgetId, Account account);
	
	public Account updateAccount(Long budgetId, Long accountId, Account account);
	
	public void deleteAccount(Long accountId);
	
}