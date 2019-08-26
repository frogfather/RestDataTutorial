package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	@Nullable
	private Integer categoryGroup;
	
	@ManyToOne
	@JoinColumn
	private Budget budget;
	
	public Category() {
		
	}
	
	public Category(Long id, String label, @Nullable Integer categoryGroup, Long budgetId) {
		this.id = id;
		this.label = label;
		this.categoryGroup = categoryGroup;
		this.budget = new Budget(budgetId, "", null, null);
	}

	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getCategoryGroup() {
		return categoryGroup;
	}
	
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
	public Budget getBudget() {
		return budget;
	}

}
