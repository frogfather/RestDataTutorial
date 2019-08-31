package com.mistymorning.housekeeper.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Seller")
@Table(name = "seller")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private String branch;
	@Column(precision=15, scale=10)
	private Double longitude;
	@Column(precision=15, scale=10)
	private Double latitude;
	
	@ManyToOne
	@JoinColumn
	private Budget budget;
	
	public Seller() {
		
	}
	
	public Seller (Long id, String label, String branch, Double longitude, Double latitude, Long budgetId) {
		this.id = id;
		this.label = label;
		this.branch = branch;
		this.longitude = longitude;
		this.latitude = latitude;
		this.budget = new Budget(budgetId, "", null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latiditude) {
		this.latitude = latiditude;
	}
	
	public Budget getBudget() {
		return budget;
	}
	
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
}
