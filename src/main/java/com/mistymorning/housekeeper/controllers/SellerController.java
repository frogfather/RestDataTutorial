package com.mistymorning.housekeeper.controllers;

import javax.ws.rs.core.Response;

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
public class SellerController extends AbstractController {

	@Autowired
	private SellerService sellerService;
	
	@RequestMapping("/sellers")
	public Response getAllAccounts(@PathVariable Long budgetId) {
		return buildResponse(true,sellerService.getAllSellers(budgetId));
	}
	
	@RequestMapping("/sellers/{sellerId}")
	public Response getSeller(@PathVariable Long budgetId, @PathVariable Long sellerId) {
		return buildResponse(true,sellerService.getSeller(budgetId, sellerId));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sellers")
	public Response addSeller(@PathVariable Long budgetId, @RequestBody Seller seller) {
		return buildResponse(true,sellerService.addSeller(budgetId, seller));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/sellers/{sellerId}")
	public Response updateSeller(@PathVariable Long budgetId, @PathVariable Long sellerId, @RequestBody Seller seller) {
		return buildResponse(true,sellerService.updateSeller(budgetId, sellerId, seller));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/sellers/{sellerId}") 
	public void deleteSeller(@PathVariable Long budgetId, @PathVariable Long sellerId) 
	{
		sellerService.deleteSeller(sellerId);
	}
	
}
