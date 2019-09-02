package com.mistymorning.housekeeper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Allocation;

public interface AllocationRepository extends CrudRepository<Allocation, Long>{
	public List<Allocation> findByBudgetId(Long budgetId);
}
