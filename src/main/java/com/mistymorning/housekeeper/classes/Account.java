package com.mistymorning.housekeeper.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private String id;
	private String label;
	private String description;

	public Account() {
		
	}
	
	public Account(String id, String label, String description) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getDescription() {
		return description;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}