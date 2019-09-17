package com.mistymorning.housekeeper.controllers;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Budget;
import com.mistymorning.housekeeper.services.api.BudgetService;

@RestController
@RequestMapping("/budgets")
public class BudgetController extends AbstractController {

	@Autowired
	private BudgetService budgetService;
	
	@RequestMapping("/")
	public Response getAllBudgets() {
		return buildResponse(true, this.budgetService.getAll());
	}
	
	@RequestMapping("/{id}")
	public Response getBudget(@PathVariable Long id) {
		return buildResponse(true,this.budgetService.getBudget(id));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/")
	public Response addBudget(@RequestBody Budget budget) {
		return buildResponse(true,this.budgetService.addBudget(budget));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public Response updateBudget(@RequestBody Budget budget, @PathVariable Long id) {
		return buildResponse(true,this.budgetService.updateBudget(id, budget));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteBudget(@PathVariable Long id) {
		this.budgetService.deleteBudget(id);
	}
	
}
