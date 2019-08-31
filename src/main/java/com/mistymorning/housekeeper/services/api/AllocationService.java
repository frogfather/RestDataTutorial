package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Allocation;

public interface AllocationService {

	public List<Allocation> getAll();
	
	public Allocation getAllocation(Long allocationId);
	
	public Allocation addAllocation(Allocation allocation);
	
	public Allocation updateAllocation(String id, Allocation allocation);
	
	public void deleteAllocation(Long allocationId);
	
}
