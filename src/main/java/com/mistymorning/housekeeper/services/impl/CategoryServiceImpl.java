package com.mistymorning.housekeeper.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Category;
import com.mistymorning.housekeeper.repository.CategoryRepository;
import com.mistymorning.housekeeper.services.api.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAll() {
		List<Category> categoryList = new ArrayList<>();
		this.categoryRepository.findAll().forEach(categoryList::add);
		return categoryList;
	}

	@Override
	public Category getCategory(String id) {
		Optional<Category> found = this.categoryRepository.findById(id);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public Category addCategory(Category category) {
		this.categoryRepository.save(category);
		return category;
	}

	@Override
	public Category updateCategory(String id, Category category) {
		this.categoryRepository.save(category);
		return category;
	}

	@Override
	public void deleteCategory(String id) {
		this.categoryRepository.deleteById(id);
	}

}
