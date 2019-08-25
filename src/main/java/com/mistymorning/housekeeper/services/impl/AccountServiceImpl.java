package com.mistymorning.housekeeper.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Account;
import com.mistymorning.housekeeper.classes.Budget;
import com.mistymorning.housekeeper.repository.AccountRepository;
import com.mistymorning.housekeeper.repository.BudgetRepository;
import com.mistymorning.housekeeper.services.api.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private BudgetRepository budgetRepository;

	@Override
	public List<Account> getAllAccounts(Long budgetId) {
		return this.accountRepository.findByBudgetId(budgetId);
	}
	
	public Account getAccount(Long budgetId, Long id) {
		return this.accountRepository.findByBudgetId(budgetId).stream().filter( acc -> acc.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Account addAccount(Long budgetId, Account account) {
		Optional<Budget> budget = budgetRepository.findById(budgetId);
		if (budget == null) {
			//TODO Throw an error here
			return null;
		}else {
			System.out.println("Account number "+account.getId());
			account.setBudget(budget.get());
			this.accountRepository.save(account);
			return account;	
		}
		
	}

	@Override
	public Account updateAccount(Long id, Account account) {
		Optional<Account> existingAccount = this.accountRepository.findById(id);
		if (existingAccount == null) {
			//throw exception
		}
		//Update the fields - or is there an easier way?
		this.accountRepository.save(account);
		return account;
	}
	
	@Override
	public Account deleteAccount(Long accountId) {
		Optional<Account> account = accountRepository.findById(accountId);
		if (account == null) {
			return null;
			//TODO: throw an error
		}else {
			this.accountRepository.deleteById(accountId);
			return account.get();
		}
		
	}

}