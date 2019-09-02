package com.mistymorning.housekeeper.services.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mistymorning.housekeeper.classes.Allocation;
import com.mistymorning.housekeeper.repository.AllocationRepository;
import com.mistymorning.housekeeper.services.api.AllocationService;
import com.mistymorning.housekeeper.utilities.Utilities;

@Service
public class AllocationServiceImpl implements AllocationService {
	
	@Autowired
	private AllocationRepository allocationRepository;
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("allocation-unit");
	
	@Override
	public List<Allocation> getAllocations(Long budgetId, Date date) {
		List<Allocation> results = new ArrayList<>();
		EntityManager em = entityManagerFactory.createEntityManager();
		List<?> qList = em.createQuery(
	              "SELECT e FROM Allocation e WHERE e.startDate <= "+date+" AND e.endDate >= date AND e.budget_Id = "+budgetId).getResultList();
		for (Object resultObject : qList) {
			Allocation allocation = (Allocation) resultObject;
			results.add(allocation);
		}
		return results;
	}

	@Override
	public Allocation getAllocation(Long budgetId, Long categoryId, Date date) {
		return this.getAllocations(budgetId, date).stream().filter( alc -> alc.getCategory().getId().equals(categoryId)).findFirst().orElse(null);
	}

	@Override
	public Allocation addAllocation(Long budgetId, Long categoryId, Date date, Allocation allocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Allocation updateAllocation(Long budgetId, Long categoryId, Long allocationId, Allocation allocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllocation(Long allocationId) {
		// TODO Auto-generated method stub
		
	}
}
