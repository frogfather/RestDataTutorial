package com.mistymorning.housekeeper.classes;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Transaction")
@Table(name = "transaction")
public class Transaction {
	
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;	
	private Date date;
	private String note;
	@Column(precision=10, scale=2)
	private Double amount;
	private Timestamp entered;
	private Boolean cleared;
	private Boolean locked;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Seller seller;
	
	public Transaction() {
		
	}
	
	public Transaction(UUID id, Date date, String note, Double amount, Long accountId, Long categoryId, Long sellerId, Long budgetId) {
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
	
	public UUID getId() {
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
