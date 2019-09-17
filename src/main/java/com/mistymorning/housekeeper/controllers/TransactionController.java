package com.mistymorning.housekeeper.controllers;

import javax.ws.rs.core.Response;

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
public class TransactionController extends AbstractController{

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/")
	public Response all() {
		return buildResponse(true,transactionService.getAll());
	}
	
	@RequestMapping("/{id}")
	public Response getAccount(@PathVariable Long id) {
		return buildResponse(true,transactionService.getTransaction(id));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/")
	public Response addTransaction(@RequestBody Transaction transaction) {
		return buildResponse(true,transactionService.addTransaction(transaction));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{transactionId}")
	public Response updateTransaction(@PathVariable Long transactionId, @RequestBody Transaction transaction) {
		return buildResponse(true,transactionService.updateTransaction(transactionId, transaction));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{transactionId}")
	public void deleteTransaction(@PathVariable Long transactionId) {
		transactionService.deleteTransaction(transactionId);
	}
}
