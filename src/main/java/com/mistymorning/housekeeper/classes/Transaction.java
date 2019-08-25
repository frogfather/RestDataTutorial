package com.mistymorning.housekeeper.classes;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	private String id;
	private Date date;
	private String note;
	@Column(precision=10, scale=2)
	private Double amount;
	private Timestamp entered;
	private Boolean cleared;
	private Boolean locked;
	
	@ManyToOne
	@JoinColumn
	private Account account;
	
	@ManyToOne
	@JoinColumn
	private Category category;
	
	@ManyToOne
	@JoinColumn
	private Seller seller;
	
	public Transaction() {
		
	}
	
	public Transaction(String id, Date date, String note, Double amount, Long accountId, Long categoryId, Long sellerId, Long budgetId) {
		this.id = id;
		this.date = date;
		this.note = note;
		this.amount = amount;
		this.entered = getTimestamp();
		this.setCleared(false);
		this.setLocked(false);
		this.account = new Account(accountId, "", "", null, budgetId);
		this.category = new Category(categoryId, "", -1, budgetId);
		this.seller = new Seller(sellerId, "", "", 0.0, 0.0, budgetId);
	}
	
	public String getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getEntered() {
		return entered;
	}

	public Boolean getCleared() {
		return cleared;
	}

	public void setCleared(Boolean cleared) {
		this.cleared = cleared;
	}
	
	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public static Timestamp getTimestamp() {
        Date date = new Date();
        long time = date.getTime();
        return new Timestamp(time);
    }
}
