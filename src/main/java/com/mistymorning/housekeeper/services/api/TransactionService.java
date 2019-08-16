package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Transaction;

public interface TransactionService {
	
	public List<Transaction> getAll();
	
	public Transaction getTransaction(String id);
	
	public Transaction addTransaction(Transaction transaction);
	
	public Transaction updateTransaction(String id, Transaction transaction);
	
	public void deleteTransaction(String id);

}
