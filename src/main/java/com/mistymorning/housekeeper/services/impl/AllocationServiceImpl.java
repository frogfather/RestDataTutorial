package com.mistymorning.housekeeper.services.impl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Allocation;
import com.mistymorning.housekeeper.repository.AllocationRepository;
import com.mistymorning.housekeeper.services.api.AllocationService;


@Service
public class AllocationServiceImpl implements AllocationService {
	
	@Autowired
	private AllocationRepository allocationRepository;
	
	@Override
	public List<Allocation> getByPeriod(Long budgetId, Long categoryId, Date periodStart, Date periodEnd) {
		return this.allocationRepository.findByPeriod(periodStart, periodEnd).stream()
				.filter( al -> al.getCategory().getId() == categoryId &&  al.getCategory().getBudget().getId() == budgetId).collect(Collectors.toList());
	}

	@Override
	public List<Allocation> getAll(Long budgetId, Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Allocation add(Long budgetId, Long categoryId, Allocation allocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Allocation update(Long budgetId, Long categoryId, Long allocationId, Allocation allocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long allocationId) {
		// TODO Auto-generated method stub
		
	}

	
}
