package com.mistymorning.housekeeper.controllers;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Category;
import com.mistymorning.housekeeper.services.api.CategoryService;

@RestController
@RequestMapping("/budgets/{budgetId}")
public class CategoryController extends AbstractController{
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/categories")
	public Response getAllCategories(@PathVariable Long budgetId) {
		return buildResponse(true,categoryService.getAllCategories(budgetId));
	}
	
	@RequestMapping("/categories/{id}")
	public Response getCategory(@PathVariable Long budgetId, @PathVariable Long categoryId) {
		return buildResponse(true,categoryService.getCategory(budgetId, categoryId));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categories")
	public Response addCategory(@PathVariable Long budgetId, @RequestBody Category category) {
		return buildResponse(true,categoryService.addCategory(budgetId, category));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/categories/{categoryId}")
	public Response updateCategory(@PathVariable Long budgetId, @PathVariable Long categoryId, @RequestBody Category category) {
		return buildResponse(true,categoryService.updateCategory(budgetId, categoryId, category));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/categories/{categoryId}") 
	public void deleteCategory(@PathVariable Long budgetId, @PathVariable Long categoryId) 
	{
		categoryService.deleteCategory(categoryId);
	}
	

	
	
}
