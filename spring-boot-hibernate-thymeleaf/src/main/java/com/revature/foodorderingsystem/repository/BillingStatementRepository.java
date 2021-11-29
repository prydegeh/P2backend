package com.revature.foodorderingsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.foodorderingsystem.model.BillingStatement;

@Repository
public interface BillingStatementRepository 
			extends CrudRepository<BillingStatement, Long> {

}
