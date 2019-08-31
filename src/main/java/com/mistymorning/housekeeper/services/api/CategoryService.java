package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Category;

public interface CategoryService {
	
	public List<Category> getAllCategories(Long budgetId);
	
	public Category getCategory(Long budgetId, Long categoryId);
	
	public Category addCategory(Long budgetId, Category category);
	
	public Category updateCategory(Long budgetId, Long categoryId, Category category);
	
	public void deleteCategory(Long categoryId);
}
