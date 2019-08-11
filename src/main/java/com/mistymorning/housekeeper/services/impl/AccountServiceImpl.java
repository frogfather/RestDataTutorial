package com.mistymorning.housekeeper.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Account;
import com.mistymorning.housekeeper.services.api.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private List<Account> accounts = Arrays.asList(
			new Account("1", "John Bank"),
			new Account("2", "Lorna Bank")
		);
	
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accounts;
	}

	public Account getAccount(String id) {
		return accounts.stream().filter( t -> t.getId().equals(id)).findFirst().get();
	}
}