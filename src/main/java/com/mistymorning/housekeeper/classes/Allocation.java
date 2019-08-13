package com.mistymorning.housekeeper.classes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Allocation {
	
	@Id
	private Integer id;
	@Column(precision=10, scale=2)
	private Double amount;
	
	public Integer getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Period getPeriod() {
		return period;
	}

	public Category getCategory() {
		return category;
	}

	@ManyToOne
	private Period period;
	@ManyToOne
	private Category category;
	
	public Allocation(Integer id, Double amount, Integer periodId, Integer categoryId) {
		this.id = id;
		this.amount = amount;
		this.period = new Period(periodId, "", null, null);
		this.category = new Category(categoryId, "", null);
	}
	
}
