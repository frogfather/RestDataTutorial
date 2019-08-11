package com.mistymorning.housekeeper.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Account;
import com.mistymorning.housekeeper.repository.AccountRepository;
import com.mistymorning.housekeeper.services.api.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAll() {
		List<Account> accountList = new ArrayList<>();
		this.accountRepository.findAll().forEach(accountList::add);
		return accountList;
	}

	public Account getAccount(String id) {
		Optional<Account> found = this.accountRepository.findById(id);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public Account addAccount(Account account) {
		this.accountRepository.save(account);
		return account;
	}

	@Override
	public Boolean deleteAccount(String id) {
		this.accountRepository.deleteById(id);
		return true;
	}

	@Override
	public Account updateAccount(String id, Account account) {
		this.accountRepository.save(account);
		return account;
	}
}