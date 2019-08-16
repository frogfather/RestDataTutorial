package com.mistymorning.housekeeper.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Seller;
import com.mistymorning.housekeeper.repository.SellerRepository;
import com.mistymorning.housekeeper.services.api.SellerService;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public List<Seller> getAll() {
		List<Seller> sellerList = new ArrayList<>();
		this.sellerRepository.findAll().forEach(sellerList::add);
		return sellerList;
	}

	@Override
	public Seller getSeller(String id) {
		Optional<Seller> found = this.sellerRepository.findById(id);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public Seller addSeller(Seller seller) {
		this.sellerRepository.save(seller);
		return seller;
	}

	@Override
	public Seller updateSeller(String id, Seller seller) {
		this.sellerRepository.save(seller);
		return seller;
	}

	@Override
	public void deleteSeller(String id) {
		this.sellerRepository.deleteById(id);
	}

}
