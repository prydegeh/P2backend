package com.revature.foodorderingsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.foodorderingsystem.exception.RecordNotFoundException;
import com.revature.foodorderingsystem.model.Product;
import com.revature.foodorderingsystem.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public List<Product> getAllProducts()
	{
		List<Product> result = (List<Product>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Product>();
		}
	}
	
	public Product getProductById(Long id) throws RecordNotFoundException 
	{
		Optional<Product> product = repository.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		} else {
			throw new RecordNotFoundException("No product record exist for given id");
		}
	}
	
	public Product createOrUpdateProduct(Product entity) 
	{
		if(Objects.isNull(entity.getId())) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<Product> product = repository.findById(entity.getId());
			
			if(product.isPresent()) 
			{
				Product newEntity = product.get();
			
				newEntity.setRestaurantName(entity.getRestaurantName());
				newEntity.setProductName(entity.getProductName());
				newEntity.setUnitPrice(entity.getUnitPrice());
				newEntity.setImg_url(entity.getImg_url());
				newEntity.setBillingStatements(entity.getBillingStatements());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteProductById(Long id) throws RecordNotFoundException 
	{
		Optional<Product> product = repository.findById(id);
		
		if(product.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No product record exist for given id");
		}
	} 
}