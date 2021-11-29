package com.revature.foodorderingsystem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
//import com.revature.foodorderingsystem.model.ListItem;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="restaurant_name")
	private String restaurantName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="img_url")
	private String img_url;
	

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "billingstatement_id")
	//@JsonManagedReference
	private List<BillingStatement> billingStatements;
	
	
	public Product() {
		super();
	}

	public Product(String productName, String restaurantName, double unitPrice, String img_url) {
		super();
	
		this.productName = productName;
		this.restaurantName = restaurantName;
		this.unitPrice = unitPrice;
		this.img_url = img_url;
		
	}
	
	/** Don't need to manually create getters & setters. Lombok's @Data annotation on the class does this for us */
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public String getRestaurantName() {
//		return restaurantName;
//	}
//
//	public void setRestaurantName(String restaurantName) {
//		this.restaurantName = restaurantName;
//	}
//
//	public double getUnitPrice() {
//		return unitPrice;
//	}
//
//	public void setUnitPrice(double unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//
//	public String getImg_url() {
//		return img_url;
//	}
//
//	public void setImg_url(String img_url) {
//		this.img_url = img_url;
//	}
//
//	public List<BillingStatement> getBillingStatements() {
//		return billingStatements;
//	}
//
//	public void setBillingStatments(List<BillingStatement> billingStatements) {
//		this.billingStatements = billingStatements;
//	}

	
	
	
	
	
	
////	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
////	private Set<ListItem> listItems = new HashSet<ListItem>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name= "billingstatement_id")
//	private List<BillingStatement> billingStatements;
//	
	
	
}
	
//	
//
//	
//	
//	
//	
//////	public void addItem(ListItem item) {
//////		this.listItems.add(item);
//////	}
////	
////
////	public long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public String getProductName() {
////		return productName;
////	}
////
////	public void setProductName(String productName) {
////		this.productName = productName;
////	}
////
////	public double getUnitPrice() {
////		return unitPrice;
////	}
////
////	public void setUnitPrice(double unitPrice) {
////		this.unitPrice = unitPrice;
////	}
////	
////
////	public Set<ListItem> getListItems(){
////		return listItems;
////		
////	}
////
////	public void setListItems(Set<ListItem> listItems) {
////		this.listItems = listItems;
////	}
////	
////	
////	public void addListItem(ListItem listItem) {
////		this.listItems.add(listItem);
////	}
//////	public List<ListItem> getListItems() {
//////		return listItems;
//////	}
////
//////	public void setListItems(List<ListItem> listItems) {
//////		this.listItems = listItems;
//////	}
////
//////	@Override
//////	public String toString() {
//////		return "Product [id=" + id + ", productName=" + productName + ", unitPrice=" + unitPrice + ", listItems="
//////				+ listItems + "]";
//////	}
//	
//	
//	
//	
//	
//}
