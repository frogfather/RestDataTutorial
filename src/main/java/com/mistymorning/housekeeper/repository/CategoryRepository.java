package com.mistymorning.housekeeper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	public List<Category> findByBudgetId(Long budgetId);
	
}
