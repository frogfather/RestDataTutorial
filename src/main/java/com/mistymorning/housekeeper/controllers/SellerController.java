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
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@RequestMapping("/sellers")
	public List<Seller> all() {
		return sellerService.getAll();
	}
	
	@RequestMapping("/sellers/{id}")
	public Seller getSeller(@PathVariable String id) {
		return sellerService.getSeller(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sellers")
	public Seller addSeller(@RequestBody Seller seller) {
		return sellerService.addSeller(seller);
	}
	
	//TODO: Add update method and delete method
	
}
