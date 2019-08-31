package com.mistymorning.housekeeper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Seller;

public interface SellerRepository extends CrudRepository<Seller, Long>{

	public List<Seller> findByBudgetId(Long budgetId);
	
}
