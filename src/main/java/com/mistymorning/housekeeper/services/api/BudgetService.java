package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Budget;

public interface BudgetService {
	
	public List<Budget> getAll();
	
	public Budget getBudget(String id);
	
	public Budget addBudget(Budget budget);
	
	public Budget updateBudget(String id, Budget budget);
	
	public void deleteBudget(String id);
	
	
}

