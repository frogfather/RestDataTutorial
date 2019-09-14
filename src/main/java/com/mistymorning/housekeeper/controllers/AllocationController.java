package com.mistymorning.housekeeper.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Allocation;
import com.mistymorning.housekeeper.services.api.AllocationService;

@RestController
@RequestMapping("/budgets/{budgetId}")
public class AllocationController {
	@Autowired
	private AllocationService allocationService;
	
	
	@RequestMapping("/allocations/{date}")
	public List<Allocation> getAllocations(@PathVariable Long budgetId, @PathVariable Date date ) {
		return allocationService.getAll(budgetId, date);
	}
	
	@RequestMapping("/categories/{categoryId}/allocations/{date}")
	public List<Allocation> getAllocation(@PathVariable Long budgetId, @PathVariable Long categoryId, @PathVariable Date periodStart, @PathVariable Date periodEnd ) {
		return allocationService.getByPeriod(budgetId, periodStart, periodEnd);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categories/{categoryId}/allocations")
	public Allocation addAllocation(@PathVariable Long budgetId, @PathVariable Long categoryId, @PathVariable Date date, @RequestBody Allocation allocation) {
		return allocationService.add(budgetId, categoryId, date, allocation);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/categories/{categoryId}/allocations/{allocationId}")
	public Allocation updateAllocation(@PathVariable Long budgetId, @PathVariable Long categoryId, Long allocationId, @RequestBody Allocation allocation) {
		return allocationService.update(budgetId, categoryId, allocationId, allocation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/allocations/{allocationId}") 
	public void deleteAccount(@PathVariable Long allocationId) 
	{
		allocationService.delete(allocationId);
	}
	
}
