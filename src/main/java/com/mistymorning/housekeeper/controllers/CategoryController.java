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

	@RequestMapping("/categories")
	public List<Category> all() {
		return categoryService.getAll();
	}
	
	@RequestMapping("/categories/{id}")
	public Category getCategory(@PathVariable String id) {
		return categoryService.getCategory(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	//TODO: Add update method and delete method
}
