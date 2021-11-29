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
//import com.revature.foodorderingsystem.model.Restaurant;
//import com.revature.foodorderingsystem.repository.RestaurantRepository;
//
//@Service
//public class RestaurantService {
//	
//	@Autowired
//	RestaurantRepository repository;
//	
//	public List<Restaurant> getAllRestaurants()
//	{
//		List<Restaurant> result = (List<Restaurant>) repository.findAll();
//		
//		if(result.size() > 0) {
//			return result;
//		} else {
//			return new ArrayList<Restaurant>();
//		}
//	}
//	
//	public Restaurant getRestaurantById(Long id) throws RecordNotFoundException 
//	{
//		Optional<Restaurant> restaurant = repository.findById(id);
//		
//		if(restaurant.isPresent()) {
//			return restaurant.get();
//		} else {
//			throw new RecordNotFoundException("No restaurant record exist for given id");
//		}
//	}
//	
//	public Restaurant createOrUpdateRestaurant(Restaurant entity) 
//	{
//		if(Objects.isNull(entity.getId())) 
//		{
//			entity = repository.save(entity);
//			
//			return entity;
//		} 
//		else 
//		{
//			Optional<Restaurant> restaurant = repository.findById(entity.getId());
//			
//			if(restaurant.isPresent()) 
//			{
//				Restaurant newEntity = restaurant.get();
//				newEntity.setBillingStatements(entity.getBillingStatements());
//				newEntity.setRestaurantLocation(entity.getRestaurantLocation());
//				newEntity.setRestaurantName(entity.getRestaurantName());
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
//	public void deleteProductById(Long id) throws RecordNotFoundException 
//	{
//		Optional<Restaurant> restaurant = repository.findById(id);
//		
//		if(restaurant.isPresent()) 
//		{
//			repository.deleteById(id);
//		} else {
//			throw new RecordNotFoundException("No restaurant record exist for given id");
//		}
//	} 
//}