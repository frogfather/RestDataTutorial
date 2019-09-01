package com.mistymorning.housekeeper.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mistymorning.housekeeper.classes.Seller;
import com.mistymorning.housekeeper.services.api.SellerService;

@RestController
@RequestMapping("/budgets/{budgetId}")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@RequestMapping("/sellers")
	public List<Seller> getAllAccounts(@PathVariable Long budgetId) {
		return sellerService.getAllSellers(budgetId);
	}
	
	@RequestMapping("/sellers/{sellerId}")
	public Seller getSeller(@PathVariable Long budgetId, @PathVariable Long sellerId) {
		return sellerService.getSeller(budgetId, sellerId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sellers")
	public Seller addSeller(@PathVariable Long budgetId, @RequestBody Seller seller) {
		return sellerService.addSeller(budgetId, seller);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/sellers/{sellerId}")
	public Seller updateSeller(@PathVariable Long budgetId, @PathVariable Long sellerId, @RequestBody Seller seller) {
		return sellerService.updateSeller(budgetId, sellerId, seller);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/sellers/{sellerId}") 
	public void deleteSeller(@PathVariable Long budgetId, @PathVariable Long sellerId) 
	{
		sellerService.deleteSeller(sellerId);
	}
	
}
