package com.mistymorning.housekeeper.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Allocation;
import com.mistymorning.housekeeper.repository.AllocationRepository;
import com.mistymorning.housekeeper.services.api.AllocationService;

@Service
public class AllocationServiceImpl implements AllocationService {
	
	@Autowired
	private AllocationRepository allocationRepository;
	
	@Override
	public List<Allocation> getAll() {
		List<Allocation> allocationList = new ArrayList<>();
		this.allocationRepository.findAll().forEach(allocationList::add);
		return allocationList;
	}

	@Override
	public Allocation getAllocation(String id) {
		Optional<Allocation> found = this.allocationRepository.findById(id);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	@Override
	public Allocation addAllocation(Allocation allocation) {
		this.allocationRepository.save(allocation);
		return allocation;
	}

	@Override
	public Allocation updateAllocation(String id, Allocation allocation) {
		this.allocationRepository.save(allocation);
		return allocation;
	}

	@Override
	public void deleteAllocation(String id) {
		this.allocationRepository.deleteById(id);
		
	}

}
