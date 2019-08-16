package com.mistymorning.housekeeper.classes;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	private Account account;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Seller seller;
	
	public Transaction() {
		
	}
	
	public Transaction(String id, Date date, String note, Double amount, String accountId, String categoryId, String sellerId) {
		this.id = id;
		this.date = date;
		this.note = note;
		this.amount = amount;
		this.account = new Account(accountId, "", "", null, null);
		this.category = new Category(categoryId, "", null, null);
		this.seller = new Seller(sellerId, "", "", null, null, null);
		this.entered = getTimestamp();
		this.cleared = false;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public static Timestamp getTimestamp() {
        Date date = new Date();
        long time = date.getTime();
        return new Timestamp(time);
    }
}
