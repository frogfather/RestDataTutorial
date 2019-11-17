package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Transaction;

public interface TransactionService {
	
	public List<Transaction> getAll();
	
	public List<Transaction> getByCategory(Long categoryId);
	
	public List<Transaction> getByAccount(Long accountId);
	
	public List<Transaction> getBySeller(Long sellerId);
	
	public Transaction getTransaction(Long transactionId);
	
	public List<Transaction> addTransactions(List<Transaction> transactions);
	
	public Transaction updateTransaction(Long t, Transaction transaction);
	
	public void deleteTransaction(Long transactionId);

}
