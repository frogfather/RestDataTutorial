package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

@Entity
public class Category {
	
	@Id
	private Integer id;
	private String label;
	@Nullable
	private Integer categoryGroup;
	private Boolean master;
	
	public Category(Integer id, String label, @Nullable Integer categoryGroup ) {
		this.id = id;
		this.label = label;
		this.master = categoryGroup == null;
		this.categoryGroup = categoryGroup == null ? -1 : categoryGroup;
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

	public Integer getCategoryGroup() {
		return categoryGroup;
	}

	public Boolean getMaster() {
		return master;
	}

}
