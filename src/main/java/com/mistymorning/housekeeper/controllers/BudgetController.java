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
	
	@RequestMapping("/budgets")
	public List<Budget> all() {
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
	
	//TODO: Add update method and delete method
}
