package com.mistymorning.housekeeper.classes;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Budget")
@Table(name = "budget")
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private Date startDate;
	private Period period;
	
	public Budget() {
		
	}
	
	public Budget(Long id, String label, Date startDate, Period period) {
		super();
		this.id = id;
		this.label = label;
		this.startDate = startDate;
		this.period = period;
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
