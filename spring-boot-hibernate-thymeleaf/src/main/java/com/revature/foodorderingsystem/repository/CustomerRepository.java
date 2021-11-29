package com.revature.foodorderingsystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.foodorderingsystem.model.Customer;

@Repository
public interface CustomerRepository 
			extends CrudRepository<Customer, Long> {
	
	public Customer findByUserName(String userName);

}
