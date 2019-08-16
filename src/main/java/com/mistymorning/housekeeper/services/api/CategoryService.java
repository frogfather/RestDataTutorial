package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Category;

public interface CategoryService {
	
	public List<Category> getAll();
	
	public Category getCategory(String id);
	
	public Category addCategory(Category category);
	
	public Category updateCategory(String id, Category category);
	
	public void deleteCategory(String id);
}
