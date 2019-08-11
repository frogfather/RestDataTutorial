package com.mistymorning.housekeeper.classes;

public class Account {

	private final String id;
	private final String label;
	
	public Account(String id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	public String getId() {
		return id;
	}
	public String getLabel() {
		return label;
	}
	
}