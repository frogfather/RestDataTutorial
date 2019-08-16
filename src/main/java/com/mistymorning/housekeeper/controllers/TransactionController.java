package com.mistymorning.housekeeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Account;
import com.mistymorning.housekeeper.classes.Transaction;
import com.mistymorning.housekeeper.services.api.AccountService;
import com.mistymorning.housekeeper.services.api.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/transactions")
	public List<Transaction> all() {
		return transactionService.getAll();
	}
	
	@RequestMapping("/transactions/{id}")
	public Transaction getAccount(@PathVariable String id) {
		return transactionService.getTransaction(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/transactions")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}
	
	//TODO: Add update method and delete method
}
