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
//import com.revature.foodorderingsystem.model.ListItem;
//import com.revature.foodorderingsystem.repository.ListItemRepository;
//
//@Service
//public class ListItemService {
//	
//	@Autowired
//	ListItemRepository repository;
//	
//	public List<ListItem> getAllListItems()
//	{
//		List<ListItem> result = (List<ListItem>) repository.findAll();
//		
//		if(result.size() > 0) {
//			return result;
//		} else {
//			return new ArrayList<ListItem>();
//		}
//	}
//	
//	public ListItem getListItemById(Long id) throws RecordNotFoundException 
//	{
//		Optional<ListItem> listItem = repository.findById(id);
//		
//		if(listItem.isPresent()) {
//			return listItem.get();
//		} else {
//			throw new RecordNotFoundException("No list item record exist for given id");
//		}
//	}
//	
//	public ListItem createOrUpdateListItem(ListItem entity) 
//	{
//		if(Objects.isNull(entity.getId())) 
//		{
//			entity = repository.save(entity);
//			
//			return entity;
//		} 
//		else 
//		{
//			Optional<ListItem> listItem = repository.findById(entity.getId());
//			
//			if(listItem.isPresent()) 
//			{
//				ListItem newEntity = listItem.get();
//				newEntity.setBillingStatement(entity.getBillingStatement());
//				newEntity.setProduct(entity.getProduct());
//				newEntity.setExtendedPrice(entity.getExtendedPrice());
//				newEntity.setQuantity(entity.getQuantity());
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
//	public void deleteListItemById(Long id) throws RecordNotFoundException 
//	{
//		Optional<ListItem> listItem = repository.findById(id);
//		
//		if(listItem.isPresent()) 
//		{
//			repository.deleteById(id);
//		} else {
//			throw new RecordNotFoundException("No list item record exist for given id");
//		}
//	} 
//}