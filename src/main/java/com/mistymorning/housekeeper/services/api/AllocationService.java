package com.mistymorning.housekeeper.services.api;

import java.sql.Date;
import java.util.List;

import com.mistymorning.housekeeper.classes.Allocation;

public interface AllocationService {
	
	public List<Allocation> getAllocations(Long budgetId, Date date);
	
	public Allocation getAllocation(Long budgetId, Long categoryId, Date date);
	
	public Allocation addAllocation(Long budgetId, Long categoryId, Date date, Allocation allocation);
	
	public Allocation updateAllocation(Long budgetId, Long categoryId, Long allocationId, Allocation allocation);
	
	public void deleteAllocation(Long allocationId);
	
}
