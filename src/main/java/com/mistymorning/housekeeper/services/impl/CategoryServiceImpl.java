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
	public Category getCategory(Long budgetId, Long categoryId) {
		Optional<Category> category = this.categoryRepository.findById(categoryId);
		if (category.isPresent() && category.get().getBudget().getId() == budgetId) {
			return category.get();
		}
		return null;
	}

	@Override
	public Category addCategory(Long budgetId, Category category) {
		Optional<Budget> budget = budgetRepository.findById(budgetId);
		Long parentCategoryId = category.getCategoryGroup().longValue();
		Category parentCategory = this.getCategory(budgetId, parentCategoryId);
		if (budget == null || (parentCategoryId != -1 && parentCategory == null)) {
			//TODO Throw an error here
			return null;
		}
			category.setBudget(budget.get());
			this.categoryRepository.save(category);
			return category;
		
	}

	@Override
	public Category updateCategory(Long budgetId, Long categoryId, Category category) {
		Optional<Budget> budget = budgetRepository.findById(budgetId);
		Category existing = this.getCategory(budgetId, categoryId);
		if (existing == null || !budget.isPresent()) {
			//TODO Throw an error here
			return null;
		}else {
			category.setBudget(budget.get());
			category.setId(categoryId);
			this.categoryRepository.save(category);
			return category;
		}
	}

	@Override
	public void deleteCategory(Long categoryId) {
		this.categoryRepository.deleteById(categoryId);
		
	}

}
