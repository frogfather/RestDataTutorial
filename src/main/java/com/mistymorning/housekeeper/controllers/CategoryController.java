package com.mistymorning.housekeeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Category;
import com.mistymorning.housekeeper.services.api.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/budgets/{budgetId}/categories")
	public List<Category> getAllCategories(@PathVariable Long budgetId) {
		return categoryService.getAllCategories(budgetId);
	}
	
	@RequestMapping("/budgets/{budgetId}/categories/{id}")
	public Category getCategory(@PathVariable Long budgetId, @PathVariable Long categoryId) {
		return categoryService.getCategory(budgetId, categoryId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/budgets/{budgetId}/categories")
	public Category addCategory(@PathVariable Long budgetId, @RequestBody Category category) {
		return categoryService.addCategory(budgetId, category);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/budgets/{budgetId}/categories/{categoryId}")
	public Category updateCategory(@PathVariable Long budgetId, @PathVariable Long categoryId, @RequestBody Category category) {
		return categoryService.updateCategory(budgetId, categoryId, category);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/budgets/{budgetId}/categories/{categoryId}") 
	public void deleteCategory(@PathVariable Long budgetId, @PathVariable Long categoryId) 
	{
		categoryService.deleteCategory(categoryId);
	}
	
}
