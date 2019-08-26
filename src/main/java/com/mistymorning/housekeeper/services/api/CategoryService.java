package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories(Long budgetId);
	
	public Category getCategory(Long budgetId, Long id);
	
	public Category addCategory(Long budgetId, Category category);
	
	public Category updateCategory(Long budgetId, Category category);
	
	public void deleteCategory(Long budgetId, Long id);
}
