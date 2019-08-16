package com.mistymorning.housekeeper.repository;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Category;

public interface CategoryRepository extends CrudRepository<Category, String>{

}
