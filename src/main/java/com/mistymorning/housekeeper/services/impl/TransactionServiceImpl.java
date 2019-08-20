package com.mistymorning.housekeeper.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Transaction;
import com.mistymorning.housekeeper.repository.TransactionRepository;
import com.mistymorning.housekeeper.services.api.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> getAll() {
		List<Transaction> transactionList = new ArrayList<>();
		this.transactionRepository.findAll().forEach(transactionList::add);
		return transactionList;
	}

	public Transaction getTransaction(String id) {
		Optional<Transaction> found = this.transactionRepository.findById(id);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		this.transactionRepository.save(transaction);
		return transaction;
	}

	@Override
	public Transaction updateTransaction(String id, Transaction transaction) {
		this.transactionRepository.save(transaction);
		return transaction;
	}
	
	@Override
	public void deleteTransaction(String id) {
		this.transactionRepository.deleteById(id);
	}

}
