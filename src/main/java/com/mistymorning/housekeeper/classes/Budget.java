package com.mistymorning.housekeeper.classes;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Budget {
	@Id
	private String id;
	private String label;
	private Date startDate;
	private Period period;
	
	public Budget() {
		
	}
	
	public Budget(String id, String label, Date startDate, Period period) {
		super();
		this.id = id;
		this.label = label;
		this.startDate = startDate;
		this.period = period;
	}

	public String getId() {
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
