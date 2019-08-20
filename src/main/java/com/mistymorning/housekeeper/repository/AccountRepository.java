package com.mistymorning.housekeeper.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	
	public List<Account> findByBudgetId(Long budgetId);
	
}
