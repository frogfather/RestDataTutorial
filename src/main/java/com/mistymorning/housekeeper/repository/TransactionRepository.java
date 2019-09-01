package com.mistymorning.housekeeper.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{

	public List<Transaction> findByCategoryId(Long categoryId);
	
	public List<Transaction> findByAccountId(Long accountId);
	
	public List<Transaction> findBySellerId(Long sellerId);
	
}
