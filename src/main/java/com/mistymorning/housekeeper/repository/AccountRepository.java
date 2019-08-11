package com.mistymorning.housekeeper.repository;

import org.springframework.data.repository.CrudRepository;

import com.mistymorning.housekeeper.classes.Account;

public interface AccountRepository extends CrudRepository<Account, String> {
	

}
