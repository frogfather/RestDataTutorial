package com.mistymorning.housekeeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Account;
import com.mistymorning.housekeeper.services.api.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public List<Account> all() {
		return accountService.getAll();
	}
	
	@RequestMapping("/accounts/{id}")
	public Account getAccount(@PathVariable String id) {
		return accountService.getAccount(id);
	}
}