package com.mistymorning.housekeeper.services.api;

import java.sql.Date;
import java.util.List;

import com.mistymorning.housekeeper.classes.Allocation;

public interface AllocationService {
	
	public List<Allocation> getAll(Long budgetId, Date date);
	
	public List<Allocation> getByPeriod(Long budgetId, Date periodStart, Date periodEnd);
	
	public Allocation add(Long budgetId, Long categoryId, Date date, Allocation allocation);
	
	public Allocation update(Long budgetId, Long categoryId, Long allocationId, Allocation allocation);
	
	public void delete(Long allocationId);
	
}
