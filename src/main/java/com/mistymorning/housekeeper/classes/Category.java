package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String label;
	@Nullable
	private Integer categoryGroup;
	
	public Category() {
		
	}
	
	public Category(Long id, String label, @Nullable Integer categoryGroup) {
		this.id = id;
		this.label = label;
		this.categoryGroup = categoryGroup;
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

}
