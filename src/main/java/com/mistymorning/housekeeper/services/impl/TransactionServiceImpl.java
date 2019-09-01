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
	//TODO Retrieving all transactions is going to return an unneccessarily large number
	//Either have separate 'retrieve all by qualifier' type 
	public List<Transaction> getAll() {
		List<Transaction> transactionList = new ArrayList<>();
		this.transactionRepository.findAll().forEach(transactionList::add);
		return transactionList;
	}

	@Override
	public List<Transaction> getByCategory(Long categoryId) {
		return this.transactionRepository.findByCategoryId(categoryId);
	}

	@Override
	public List<Transaction> getByAccount(Long accountId) {
		return this.transactionRepository.findByAccountId(accountId);
	}

	@Override
	public List<Transaction> getBySeller(Long sellerId) {
		return this.transactionRepository.findBySellerId(sellerId);
	}

	public Transaction getTransaction(Long transactionId) {
		Optional<Transaction> found = this.transactionRepository.findById(transactionId);
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
	public Transaction updateTransaction(Long transactionId, Transaction transaction) {
		this.transactionRepository.save(transaction);
		return transaction;
	}
	
	@Override
	public void deleteTransaction(Long transactionId) {
		this.transactionRepository.deleteById(transactionId);
	}

	
}
