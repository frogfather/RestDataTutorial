package com.mistymorning.housekeeper.classes;

import java.sql.Date;

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
	private Integer id;
	private Date date;
	private String note;
	@Column(precision=10, scale=2)
	private Double amount;
	
	@ManyToOne
	private Account account;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Seller seller;
	
	public Transaction(Integer id, Date date, String note, Double amount, Integer accountId, Integer categoryId, Integer sellerId) {
		this.id = id;
		this.date = date;
		this.note = note;
		this.amount = amount;
		this.account = new Account(accountId, "", "", null);
		this.category = new Category(categoryId, "", null);
		this.seller = new Seller(sellerId, "", "", null, null);
		
	}
	
}
