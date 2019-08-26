package com.mistymorning.housekeeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Budget;
import com.mistymorning.housekeeper.services.api.BudgetService;

@RestController
public class BudgetController {

	@Autowired
	private BudgetService budgetService;
	
	//Operations on budgets
	@RequestMapping("/budgets")
	public List<Budget> getAllBudgets() {
		return this.budgetService.getAll();
	}
	
	@RequestMapping("/budgets/{id}")
	public Budget getBudget(@PathVariable Long id) {
		return this.budgetService.getBudget(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/budgets")
	public Budget addBudget(@RequestBody Budget budget) {
		return this.budgetService.addBudget(budget);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/budgets/{id}")
	public Budget updateBudget(@RequestBody Budget budget, @PathVariable Long id) {
		return this.budgetService.updateBudget(id, budget);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/budgets/{id}")
	public void deleteBudget(@PathVariable Long id) {
		this.budgetService.deleteBudget(id);
	}
	
}
