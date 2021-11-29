//package com.revature.foodorderingsystem.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.revature.foodorderingsystem.exception.RecordNotFoundException;
//import com.revature.foodorderingsystem.model.ListItem;
//import com.revature.foodorderingsystem.service.ListItemService;
//
//
//@Controller
////@RequestMapping("/listItems")
//public class ListItemController 
//{
//	@Autowired
//	ListItemService service;
//
//	@RequestMapping("/listItems")
//	public String getAllProducts(Model model) 
//	{
//		List<ListItem> list = service.getAllListItems();
//
//		model.addAttribute("listItems", list);
//		return "list-listItems";
//	}
//
//	@RequestMapping(path = {"/editListItem", "/editListItem/{id}"})
//	public String editListItemById(Model model, @PathVariable("id") Optional<Long> id) 
//							throws RecordNotFoundException 
//	{
//		if (id.isPresent()) {
//			ListItem entity = service.getListItemById(id.get());
//			model.addAttribute("listItem", entity);
//		} else {
//			model.addAttribute("listItem", new ListItem());
//		}
//		return "add-edit-listItems";
//	}
//	
//	@RequestMapping(path = "/deleteListItem/{id}")
//	public String deleteListItemById(Model model, @PathVariable("id") Long id) 
//							throws RecordNotFoundException 
//	{
//		service.deleteListItemById(id);
//		return "redirect:/listItems";
//	}
//
//	@RequestMapping(path = "/createListItem", method = RequestMethod.POST)
//	public String createOrUpdateBillingStatement(ListItem listItem) 
//	{
//		service.createOrUpdateListItem(listItem);
//		return "redirect:/listItems";
//	}
//}
