package com.mistymorning.housekeeper.classes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Allocation {
	
	@Id
	private Integer id;
	@Column(precision=10, scale=2)
	private Double amount;
	private Date date;
	
	@ManyToOne
	private Category category;
	
	public Allocation(Integer id, Double amount, Date date, Integer categoryId) {
		this.id = id;
		this.amount = amount;
		this.category = new Category(categoryId, "", null);
	}
	
	public Integer getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Integer categoryId) {
		this.category = new Category(categoryId, "", null);
	}

}
