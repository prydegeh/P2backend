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
import com.revature.foodorderingsystem.model.BillingStatement;
import com.revature.foodorderingsystem.repository.BillingStatementRepository;

@Service
public class BillingStatementService {
	
	private static Logger log = LoggerFactory.getLogger(BillingStatementService.class);
	
	@Autowired
	BillingStatementRepository repository;
	
	public List<BillingStatement> getAllBillingStatements()
	{
		log.info("In getAllBillingStatements()");
		List<BillingStatement> result = (List<BillingStatement>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<BillingStatement>();
		}
	}
	
	public BillingStatement getBillingStatementById(Long id) throws RecordNotFoundException 
	{
		log.info("In getBillingStatementById()");
		Optional<BillingStatement> billingStatement = repository.findById(id);
		
		if(billingStatement.isPresent()) {
			return billingStatement.get();
		} else {
			log.info("RecordNotFoundException");
			throw new RecordNotFoundException("No billing statement record exist for given id");
		}
	}
	
	public BillingStatement createOrUpdateBillingStatement(BillingStatement entity) 
	{
		log.info("In createOrUpdateBillingStatement()");
		if(Objects.isNull(entity.getId())) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<BillingStatement> billingStatement = repository.findById(entity.getId());
			
			if(billingStatement.isPresent()) 
			{
				BillingStatement newEntity = billingStatement.get();
				newEntity.setQuantity(entity.getQuantity());
				newEntity.setExtendedPrice(entity.getExtendedPrice());
				newEntity.setProduct(entity.getProduct());
				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteBillingStatementById(Long id) throws RecordNotFoundException 
	{
		log.info("In deleteBillingStatementById()");
		Optional<BillingStatement> listItem = repository.findById(id);
		
		if(listItem.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			log.info("RecordNotFoundException");
			throw new RecordNotFoundException("No billing statement record exist for given id");
		}
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
//import com.revature.foodorderingsystem.model.BillingStatement;
//import com.revature.foodorderingsystem.repository.BillingStatementRepository;
//
//@Service
//public class BillingStatementService {
//	
//	@Autowired
//	BillingStatementRepository repository;
//	
//	public List<BillingStatement> getAllBillingStatements()
//	{
//		List<BillingStatement> result = (List<BillingStatement>) repository.findAll();
//		
//		if(result.size() > 0) {
//			return result;
//		} else {
//			return new ArrayList<BillingStatement>();
//		}
//	}
//	
//	public BillingStatement getBillingStatementById(Long id) throws RecordNotFoundException 
//	{
//		Optional<BillingStatement> billingStatement = repository.findById(id);
//		
//		if(billingStatement.isPresent()) {
//			return billingStatement.get();
//		} else {
//			throw new RecordNotFoundException("No billing statement record exist for given id");
//		}
//	}
//	
//	public BillingStatement createOrUpdateBillingStatement(BillingStatement entity) 
//	{
//		if(Objects.isNull(entity.getId())) 
//		{
//			entity = repository.save(entity);
//			
//			return entity;
//		} 
//		else 
//		{
//			Optional<BillingStatement> billingStatement = repository.findById(entity.getId());
//			
//			if(billingStatement.isPresent()) 
//			{
//				BillingStatement newEntity = billingStatement.get();
//				newEntity.setRestaurant(entity.getRestaurant());
//				newEntity.setCustomer(entity.getCustomer());
//				newEntity.setListItems(entity.getListItems());
//				newEntity.setSubTotal(entity.getSubTotal());
//				newEntity.setTax(entity.getTax());
//				newEntity.setTotal(entity.getTotal());
//				newEntity.setSubmitDate(entity.getSubmitDate());
//
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
//	public void deleteBillingStatementById(Long id) throws RecordNotFoundException 
//	{
//		Optional<BillingStatement> listItem = repository.findById(id);
//		
//		if(listItem.isPresent()) 
//		{
//			repository.deleteById(id);
//		} else {
//			throw new RecordNotFoundException("No list item record exist for given id");
//		}
//	} 
//}