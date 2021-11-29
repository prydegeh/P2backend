package com.revature.foodorderingsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.foodorderingsystem.exception.RecordNotFoundException;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private static Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	CustomerRepository repository;
	
	public List<Customer> getAllCustomers()
	{
		log.info("In getAllCustomers()");
		List<Customer> result = (List<Customer>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Customer>();
		}
	}
	
	public Customer getCustomerById(Long id) throws RecordNotFoundException 
	{
		log.info("In getCustomerById()");
		Optional<Customer> customer = repository.findById(id);
		
		if(customer.isPresent()) {
			return customer.get();
		} else {
			log.info("RecordNotFoundException");
			throw new RecordNotFoundException("No customer record exist for given id");
		}
	}
	
	public Customer createOrUpdateCustomer(Customer entity) 
	{
		log.info("In createOrUpdateCustomer()");
		if(Objects.isNull(entity.getId())) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<Customer> customer = repository.findById(entity.getId());
			
			if(customer.isPresent()) 
			{
				Customer newEntity = customer.get();
				newEntity.setEmail(entity.getEmail());
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity.setUserName(entity.getUserName());
				newEntity.setPassword(entity.getPassword());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteCustomerById(Long id) throws RecordNotFoundException 
	{
		log.info("In deleteCustomerById()");
		Optional<Customer> customer = repository.findById(id);
		
		if(customer.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			log.info("RecordNotFoundException");
			throw new RecordNotFoundException("No customer record exist for given id");
		}
	}

	
	public Customer getCustomerByUserName(String userName) throws RecordNotFoundException {
		Customer c = repository.findByUserName(userName);
		if (c== null) {
			throw new RecordNotFoundException("No customer record exist for given user name");
		}
		return c;
	}
}












//package com.revature.foodorderingsystem.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.revature.foodorderingsystem.exception.RecordNotFoundException;
//import com.revature.foodorderingsystem.model.Customer;
//import com.revature.foodorderingsystem.repository.CustomerRepository;
//
//@Service
//public class CustomerService {
//	
//	@Autowired
//	CustomerRepository repository;
//	
//	public List<Customer> getAllEmployees()
//	{
//		List<Customer> result = (List<Customer>) repository.findAll();
//		
//		if(result.size() > 0) {
//			return result;
//		} else {
//			return new ArrayList<Customer>();
//		}
//	}
//	
//	public Customer getCustomerById(Long id) throws RecordNotFoundException 
//	{
//		Optional<Customer> customer = repository.findById(id);
//		
//		if(customer.isPresent()) {
//			return customer.get();
//		} else {
//			throw new RecordNotFoundException("No customer record exist for given id");
//		}
//	}
//	
//	public Customer createOrUpdateCustomer(Customer entity) 
//	{
//		if(Objects.isNull(entity.getId())) 
//		{
//			entity = repository.save(entity);
//			
//			return entity;
//		} 
//		else 
//		{
//			Optional<Customer> customer = repository.findById(entity.getId());
//			
//			if(customer.isPresent()) 
//			{
//				Customer newEntity = customer.get();
//				newEntity.setEmail(entity.getEmail());
//				newEntity.setFirstName(entity.getFirstName());
//				newEntity.setLastName(entity.getLastName());
//
//				newEntity = repository.save(newEntity);
//				
//				return newEntity;
//			} else {
//				entity = repository.save(entity);
//				
//				return entity;
//			}
//		}
//	} 
//	
//	public void deleteCustomerById(Long id) throws RecordNotFoundException 
//	{
//		Optional<Customer> customer = repository.findById(id);
//		
//		if(customer.isPresent()) 
//		{
//			repository.deleteById(id);
//		} else {
//			throw new RecordNotFoundException("No customer record exist for given id");
//		}
//	} 
//}