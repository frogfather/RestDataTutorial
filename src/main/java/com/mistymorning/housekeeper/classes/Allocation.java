package com.mistymorning.housekeeper.classes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Allocation")
@Table(name = "allocation")
public class Allocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(precision=10, scale=2)
	private Double amount;
	private Date date;
	
	@ManyToOne
	private Category category;
	
	public Allocation() {
		
	}
	
	public Allocation(Long id, Double amount, Date date, Long categoryId) {
		this.id = id;
		this.amount = amount;
		this.category = new Category(categoryId, "", null, null);
	}
	
	public Long getId() {
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
	
	public void setCategory(Category category) {
		this.category = category;
	}

}
