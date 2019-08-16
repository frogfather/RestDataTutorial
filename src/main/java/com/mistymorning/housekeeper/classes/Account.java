package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	private String id;
	private String label;
	private String description;
	private AccountType accountType;
	@ManyToOne
	private Budget budget;
	
	public Account() {
		
	}
	
	public Account(String id, String label, String description, AccountType accountType, String budgetId) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.accountType = accountType;
		this.budget = new Budget(budgetId, "", null, null);
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}