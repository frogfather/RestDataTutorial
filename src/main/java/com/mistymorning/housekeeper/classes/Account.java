package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Account")
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private String description;
	private AccountType accountType;
	
	@ManyToOne
	@JoinColumn
	private Budget budget;
	
	public Account() {
		
	}
	
	public Account(Long id, String label, String description, AccountType accountType, Long budgetId) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.accountType = accountType;
		this.budget = new Budget(budgetId, "", null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Account )) return false;
		return id != null && id.equals(((Account) o).getId());
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	
}