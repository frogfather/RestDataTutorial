package com.mistymorning.housekeeper.repository;

import java.sql.Date;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mistymorning.housekeeper.classes.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {
	
	//Find allocation where supplied date is >= startDate and <=endDate
	@Query(value = "SELECT * FROM allocation a WHERE a.periodDate >= :startDate AND a.periodDate <= :endDate", nativeQuery = true)
	List<Allocation> findByPeriod(Date periodStart, Date periodEnd);
	
}

