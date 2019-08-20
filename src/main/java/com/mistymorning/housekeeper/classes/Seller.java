package com.mistymorning.housekeeper.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seller {
	
	@Id
	@GeneratedValue
	private Long id;
	private String label;
	private String branch;
	@Column(precision=15, scale=10)
	private Double longitude;
	@Column(precision=15, scale=10)
	private Double latiditude;
	
	public Seller() {
		
	}
	
	public Seller (Long id, String label, String branch, Double longitude, Double latitude) {
		this.id = id;
		this.label = label;
		this.branch = branch;
		this.longitude = longitude;
		this.latiditude = latitude;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Double getLongditude() {
		return longitude;
	}

	public void setLongditude(Double longditude) {
		this.longitude = longditude;
	}

	public Double getLatiditude() {
		return latiditude;
	}

	public void setLatiditude(Double latiditude) {
		this.latiditude = latiditude;
	}
}
