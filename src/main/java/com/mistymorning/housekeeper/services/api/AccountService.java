package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Account;

public interface AccountService {

	public List<Account> getAll();
	
	public Account getAccount(String id);
	
}