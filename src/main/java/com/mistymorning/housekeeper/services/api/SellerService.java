package com.mistymorning.housekeeper.services.api;

import java.util.List;

import com.mistymorning.housekeeper.classes.Seller;

public interface SellerService {
	
	public List<Seller> getAll();
	
	public Seller getSeller(String id);
	
	public Seller addSeller(Seller seller);
	
	public Seller updateSeller(String id, Seller seller);
	
	public void deleteSeller(String id);

}
