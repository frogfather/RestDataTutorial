package com.mistymorning.housekeeper.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Budget;
import com.mistymorning.housekeeper.classes.Seller;
import com.mistymorning.housekeeper.repository.BudgetRepository;
import com.mistymorning.housekeeper.repository.SellerRepository;
import com.mistymorning.housekeeper.services.api.SellerService;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Override
	public List<Seller> getAllSellers(Long budgetId) {
		return this.sellerRepository.findByBudgetId(budgetId);
	}

	@Override
	public Seller getSeller(Long budgetId, Long sellerId) {
		Optional<Seller> found = this.sellerRepository.findById(sellerId);
		if (found.isPresent() && found.get().getBudget().getId() == budgetId) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public Seller addSeller(Long budgetId, Seller seller) {
		Optional<Budget> budget = budgetRepository.findById(budgetId);
		if (budget == null) {
			//TODO Throw an error here
			return null;
		}else {
			seller.setBudget(budget.get());
			this.sellerRepository.save(seller);
			return seller;	
		}
	}

	@Override
	public Seller updateSeller(Long budgetId, Long sellerId, Seller seller) {
		Optional<Budget> budget = this.budgetRepository.findById(budgetId);
		Seller existing = this.getSeller(budgetId, sellerId);
		if (existing == null || !budget.isPresent()) {
			//TODO Throw an error here
			return null;
		} else {
			seller.setBudget(budget.get());
			seller.setId(sellerId);
			this.sellerRepository.save(seller);
			return seller;
		}
	}

	@Override
	public void deleteSeller(Long sellerId) {
		this.sellerRepository.deleteById(sellerId);
	}

}
