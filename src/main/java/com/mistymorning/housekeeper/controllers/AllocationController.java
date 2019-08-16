package com.mistymorning.housekeeper.controllers;

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
public class AllocationController {
	
	@Autowired
	private AllocationService allocationService;
	
	@RequestMapping("/allocations")
	public List<Allocation> all() {
		return allocationService.getAll();
	}
	
	@RequestMapping("/allocations/{id}")
	public Allocation getAllocation(@PathVariable String id) {
		return allocationService.getAllocation(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/allocations")
	public Allocation addAllocation(@RequestBody Allocation allocation) {
		return allocationService.addAllocation(allocation);
	}
	
	//TODO: Add update method and delete method
	
}
