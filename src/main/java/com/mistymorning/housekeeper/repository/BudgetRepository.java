package com.mistymorning.housekeeper.repository;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Budget;

public interface BudgetRepository extends CrudRepository<Budget, Long>{
	
}
