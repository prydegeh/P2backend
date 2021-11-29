package com.revature.foodorderingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.foodorderingsystem.model.Product;

@Repository
public interface ProductRepository 
			extends JpaRepository<Product, Long> {

}
