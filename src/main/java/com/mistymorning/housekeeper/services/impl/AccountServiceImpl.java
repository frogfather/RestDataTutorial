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
	
	public Account getAccount(Long budgetId, Long accountId) {
		Optional<Account> account = this.accountRepository.findById(accountId);
		if (account.isPresent() && account.get().getBudget().getId()==budgetId) {
			return account.get();
		}
		return null;
	}

	@Override
	public Account addAccount(Long budgetId, Account account) {
		Optional<Budget> budget = budgetRepository.findById(budgetId);
		if (budget == null) {
			//TODO Throw an error here
			return null;
		}else {
			account.setBudget(budget.get());
			this.accountRepository.save(account);
			return account;	
		}
		
	}

	@Override
	public Account updateAccount(Long budgetId, Long accountId, Account account) {
		Optional<Budget> budget = this.budgetRepository.findById(budgetId);
		Account existing = this.getAccount(budgetId, accountId);
		if (existing == null || !budget.isPresent()) {
			//TODO Throw an error here
			return null;
		} else {
			account.setBudget(budget.get());
			account.setId(accountId);
			this.accountRepository.save(account);
			return account;
		}
	}
	
	@Override
	public void deleteAccount(Long budgetId, Long accountId) {
		Account account = this.getAccount(budgetId, accountId);
		account.setBudget(null);
		this.accountRepository.deleteById(accountId);
	}

}