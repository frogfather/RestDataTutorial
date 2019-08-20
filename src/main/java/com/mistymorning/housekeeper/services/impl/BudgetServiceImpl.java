package com.mistymorning.housekeeper.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Budget;
import com.mistymorning.housekeeper.repository.BudgetRepository;
import com.mistymorning.housekeeper.services.api.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	private BudgetRepository budgetRepository;
	
	@Override
	public List<Budget> getAll() {
		List<Budget> budgetList = new ArrayList<>();
		this.budgetRepository.findAll().forEach(budgetList::add);
		return budgetList;
	}

	@Override
	public Budget getBudget(Long id) {
		Optional<Budget> found = this.budgetRepository.findById(id);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public Budget addBudget(Budget budget) {
		this.budgetRepository.save(budget);
		return budget;
	}

	@Override
	public Budget updateBudget(Long id, Budget budget) {
		this.budgetRepository.save(budget);
		return budget;
	}

	@Override
	public void deleteBudget(Long id) {
		this.budgetRepository.deleteById(id);
	}

	
}
