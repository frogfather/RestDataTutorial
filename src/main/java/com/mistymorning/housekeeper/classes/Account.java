package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private Integer id;
	private String label;
	private String description;
	private AccountType accountType;
	
	public Account(Integer id, String label, String description, AccountType accountType) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.accountType = accountType;
	}

	public Integer getId() {
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