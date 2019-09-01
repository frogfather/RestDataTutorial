package com.mistymorning.housekeeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Transaction;
import com.mistymorning.housekeeper.services.api.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/")
	public List<Transaction> all() {
		return transactionService.getAll();
	}
	
	@RequestMapping("/{id}")
	public Transaction getAccount(@PathVariable Long id) {
		return transactionService.getTransaction(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{transactionId}")
	public Transaction updateTransaction(@PathVariable Long transactionId, @RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transactionId, transaction);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{transactionId}")
	public void deleteTransaction(@PathVariable Long transactionId) {
		transactionService.deleteTransaction(transactionId);
	}
}
