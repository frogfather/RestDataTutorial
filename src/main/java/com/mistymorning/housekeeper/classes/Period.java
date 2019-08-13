package com.mistymorning.housekeeper.classes;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Period {
	
	@Id
	private Integer id;
	private String label;
	private Date periodStart;
	private Date periodEnd;

	public Period(Integer id, String label, Date periodStart, Date periodEnd) {
		this.id = id;
		this.label = label;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
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

	public Date getPeriodStart() {
		return periodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}
	
}
