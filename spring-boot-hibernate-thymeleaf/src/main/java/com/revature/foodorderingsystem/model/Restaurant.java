//package com.revature.foodorderingsystem.model;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "restaurant")
//public class Restaurant {
//	
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	@Column(name="restaurant_id")
//	private long id;
//	@Column(name="restaurant_name")
//	private String restaurantName;
//	@Column(name="restaurant_location")
//	private String restaurantLocation;
////	@OneToMany(cascade = CascadeType.ALL)
////	@JoinColumn(name="restaurant_id")
////	private List<BillingStatement> billingstatements;
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
//	private Set<BillingStatement> billingStatements = new HashSet<BillingStatement>();
//	
//	
//	
//	
//	public Restaurant() {
//		super();
//	}
//	public Restaurant(String restaurantName, String restaurantLocation) {
//		super();
//		//this.restaurant_id = restaurant_id;
//		this.restaurantName = restaurantName;
//		this.restaurantLocation = restaurantLocation;
//		//this.billingstatements = billingstatements;
//	}
//	public long getId() {
//		return id;
//	}
//	public void setRestaurant_id(long id) {
//		this.id = id;
//	}
//	public String getRestaurantName() {
//		return restaurantName;
//	}
//	public void setRestaurantName(String restaurantName) {
//		this.restaurantName = restaurantName;
//	}
//	public String getRestaurantLocation() {
//		return restaurantLocation;
//	}
//	public void setRestaurantLocation(String restaurantLocation) {
//		this.restaurantLocation = restaurantLocation;
//	}
//	public Set<BillingStatement> getBillingStatements() {
//		return billingStatements;
//	}
//	public void setBillingStatements(Set<BillingStatement> billingStatements) {
//		this.billingStatements = billingStatements;
//	}
//	
//
//}
//
//
//
//
//
////public long getRestaurant_id() {
////	return restaurant_id;
////}
////public void setRestaurant_id(int restaurant_id) {
////	this.restaurant_id = restaurant_id;
////}
////public String getRestaurantName() {
////	return restaurantName;
////}
////public void setRestaurantName(String restaurantName) {
////	this.restaurantName = restaurantName;
////}
////public String getRestaurantLocation() {
////	return restaurantLocation;
////}
////public void setRestaurantLocation(String restaurantLocation) {
////	this.restaurantLocation = restaurantLocation;
////}
////
////
////
////public Set<BillingStatement> getBillingStatements() {
////    return billingStatements;
////}
////
////public void setBillingStatements(Set<BillingStatement> billingStatements) {
////	this.billingStatements = billingStatements;
////}
////
////public void addbillingStatement(BillingStatement billingStatement) {
////	this.billingStatements.add(billingStatement);
////}
////
//////public List<BillingStatement> getBillingstatements() {
//////	return billingstatements;
//////}
//////public void setBillingstatements(List<BillingStatement> billingstatements) {
//////	this.billingstatements = billingstatements;
//////}
//////@Override
//////public String toString() {
//////	return "Restaurant [restaurant_id=" + restaurant_id + ", restaurantName=" + restaurantName
//////			+ ", restaurantLocation=" + restaurantLocation + ", billingstatements=" + billingstatements + "]";
//////}
////
//
//
//
//
