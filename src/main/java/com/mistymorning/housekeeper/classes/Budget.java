package com.mistymorning.housekeeper.classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private Date startDate;
	private Period period;

	@OneToMany(
		fetch = FetchType.EAGER,
		mappedBy = "budget",
		cascade = CascadeType.ALL
		)
	private List<Account> accounts = new ArrayList<>();
	
	public Budget() {
		
	}
	
	public Budget(Long id, String label, Date startDate, Period period) {
		super();
		this.id = id;
		this.label = label;
		this.startDate = startDate;
		this.period = period;
	}

	public void addAccount(Account account) {
		accounts.add(account);
		account.setBudget(this);
	}
	
	public void removeAccount(Account account) {
		accounts.remove(account);
		account.setBudget(null);
	}
	
	public Long getId() {
		return this.id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getStartDate() {
		return this.startDate;
	}
	
	public Period getPeriod() {
		return this.period;
	}	
	
	
	
}
