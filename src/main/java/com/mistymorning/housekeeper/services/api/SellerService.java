package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Seller;

public interface SellerService {
	
	public List<Seller> getAllSellers(Long budgetId);
	
	public Seller getSeller(Long budgetId, Long SellerId);
	
	public Seller addSeller(Long budgetId, Seller seller);
	
	public Seller updateSeller(Long budgetId, Long sellerId, Seller seller);
	
	public void deleteSeller(Long sellerId);

}
