package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

@Entity
public class Category {
	
	@Id
	private String id;
	private String label;
	@Nullable
	private Integer categoryGroup;
	private Boolean master;
	@ManyToOne
	private Budget budget;
	
	public Category() {
		
	}
	
	public Category(String id, String label, @Nullable Integer categoryGroup, String budgetId) {
		this.id = id;
		this.label = label;
		this.master = categoryGroup == null;
		this.categoryGroup = categoryGroup == null ? -1 : categoryGroup;
		this.budget = new Budget(budgetId, "", null, null);
	}

	public String getId() {
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

	public Boolean getMaster() {
		return master;
	}

}
