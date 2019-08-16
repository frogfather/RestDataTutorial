package com.mistymorning.housekeeper.repository;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, String>{

}
