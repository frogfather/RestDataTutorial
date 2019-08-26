package com.mistymorning.housekeeper.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Budget;
import com.mistymorning.housekeeper.classes.Category;
import com.mistymorning.housekeeper.repository.BudgetRepository;
import com.mistymorning.housekeeper.repository.CategoryRepository;
import com.mistymorning.housekeeper.services.api.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Override
	public List<Category> getAllCategories(Long budgetId) {
		return this.categoryRepository.findByBudgetId(budgetId);
	}

	@Override
	public Category getCategory(Long budgetId, Long id) {
		return this.categoryRepository.findByBudgetId(budgetId).stream().filter( cat -> cat.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Category addCategory(Long budgetId, Category category) {
		Optional<Budget> budget = budgetRepository.findById(budgetId);
		if (budget == null) {
			//TODO Throw an error here
			return null;
		}else {
			System.out.println("Budget "+ budget.get().getId());
			System.out.println("Category "+category.getLabel());
			category.setBudget(budget.get());
			this.categoryRepository.save(category);
			return category;
		}
	
	}

	@Override
	public Category updateCategory(Long budgetId, Category category) {
		Optional<Budget> budget = budgetRepository.findById(budgetId);
		if (budget == null) {
			//TODO Throw an error here
			return null;
		}else {
			category.setBudget(budget.get());
			this.categoryRepository.save(category);
			return category;
		}
	}

	@Override
	public void deleteCategory(Long budgetId, Long categoryId) {
		Category category = this.getCategory(budgetId, categoryId);
		category.setBudget(null);
		this.categoryRepository.deleteById(categoryId);
		
	}

}
