package com.mistymorning.housekeeper.controllers;

import java.sql.Date;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Allocation;
import com.mistymorning.housekeeper.services.api.AllocationService;

@RestController
@RequestMapping("/budgets/{budgetId}/category/{categoryId}")
public class AllocationController extends AbstractController {
	@Autowired
	private AllocationService allocationService;
	
	
	@RequestMapping("/allocations")
	public Response getAllocations(@PathVariable Long budgetId, @PathVariable Long categoryId ) {
		return buildResponse(true, allocationService.getAll(budgetId, categoryId));
	}
	
	@RequestMapping("/allocations/{date}")
	public Response getAllocation(@PathVariable Long budgetId, @PathVariable Long categoryId, @PathVariable Date periodStart, @PathVariable Date periodEnd ) {
		return buildResponse(true, allocationService.getByPeriod(budgetId, categoryId, periodStart, periodEnd));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/allocations")
	public Response addAllocation(@PathVariable Long budgetId, @PathVariable Long categoryId, @RequestBody Allocation allocation) {
		return buildResponse(true, allocationService.add(budgetId, categoryId, allocation));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/allocations/{allocationId}")
	public Response updateAllocation(@PathVariable Long budgetId, @PathVariable Long categoryId, Long allocationId, @RequestBody Allocation allocation) {
		return buildResponse(true, allocationService.update(budgetId, categoryId, allocationId, allocation));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/") 
	public void deleteAccount(@PathVariable Long allocationId) 
	{
		allocationService.delete(allocationId);
	}
	
}
