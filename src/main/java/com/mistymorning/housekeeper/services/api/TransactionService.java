package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Transaction;

public interface TransactionService {
	
	public List<Transaction> getAll();
	
	public Transaction getTransaction(Long transactionId);
	
	public Transaction addTransaction(Transaction transaction);
	
	public Transaction updateTransaction(Long transactionId, Transaction transaction);
	
	public void deleteTransaction(Long transactionId);

}
