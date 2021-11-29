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
//import com.revature.foodorderingsystem.model.Restaurant;
//import com.revature.foodorderingsystem.service.RestaurantService;
//
//
//@Controller
////@RequestMapping("/restaurants")
//public class RestaurantController 
//{
//	@Autowired
//	RestaurantService service;
//
//	@RequestMapping("/restaurants")
//	public String getAllRestaurants(Model model) 
//	{
//		List<Restaurant> list = service.getAllRestaurants();
//
//		model.addAttribute("restaurants", list);
//		return "list-restaurants";
//	}
//
//	@RequestMapping(path = {"/editRestaurant", "/editRestaurant/{id}"})
//	public String editRestaurantById(Model model, @PathVariable("id") Optional<Long> id) 
//							throws RecordNotFoundException 
//	{
//		if (id.isPresent()) {
//			Restaurant entity = service.getRestaurantById(id.get());
//			model.addAttribute("restaurant", entity);
//		} else {
//			model.addAttribute("restaurant", new Restaurant());
//		}
//		return "add-edit-restaurants";
//	}
//	
//	@RequestMapping(path = "/deleteRestaurant/{id}")
//	public String deleteRestaurantById(Model model, @PathVariable("id") Long id) 
//							throws RecordNotFoundException 
//	{
//		service.getRestaurantById(id);
//		return "redirect:/restaurants";
//	}
//
//	@RequestMapping(path = "/createRestaurant", method = RequestMethod.POST)
//	public String createOrUpdateRestaurant(Restaurant restaurant) 
//	{
//		service.createOrUpdateRestaurant(restaurant);
//		return "redirect:/restaurants";
//	}
//}
