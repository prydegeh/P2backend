//package com.revature.foodorderingsystem.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "list_item")
//public class ListItem {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="list_item_id")
//	private long id;
////	@Column(name="billingstatement_id")
////	private int billingStatmentId;
////	@Column(name="product_id")
////	private int productId; 
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "billingstatement_id")
//	private BillingStatement billingStatement;
//	
//	
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//	private Product product;
//	@Column(name="quantity")
//	private int quantity;
//	@Column(name="extendedPrice")
//	private double extendedPrice;
//	
//	public ListItem() {
//		super();
//	}
//
//	public ListItem(int quantity, double extendedPrice) {
//		super();
////		this.billingStatmentId = billingStatmentId;
////		this.productId = productId;
//		this.quantity = quantity;
//		this.extendedPrice = extendedPrice;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setListItemId(long id) {
//		this.id = id;
//	}
//
//	public BillingStatement getBillingStatement() {
//		return billingStatement;
//	}
//
//	public void setBillingStatement(BillingStatement billingStatement) {
//		this.billingStatement = billingStatement;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public double getExtendedPrice() {
//		return extendedPrice;
//	}
//
//	public void setExtendedPrice(double extendedPrice) {
//		this.extendedPrice = extendedPrice;
//	}
//
//	
//
//	
//	
//}
//
//
//
//
//
////public long getListItemId() {
////	return listItemId;
////}
////
//////public int getListItemId() {
//////	return listItemId;
//////}
////
////public void setListItemId(long listItemId) {
////	this.listItemId = listItemId;
////}
////
////
////
////public BillingStatement getBillingStatement() {
////	return billingStatement;
////}
////
////public void setBillingStatment(BillingStatement billingStatment) {
////	this.billingStatement = billingStatment;
////}
////
////
////
////public Product getProduct() {
////    return product;
////}
////
////public void setProduct(Product product) {
////	this.product = product;
////}
//////public int getProductId() {
//////	return productId;
//////}
//////
//////public void setProductId(int productId) {
//////	this.productId = productId;
//////}
////
////public int getQuantity() {
////	return quantity;
////}
////
////public void setQuantity(int quantity) {
////	this.quantity = quantity;
////}
////
////public double getExtendedPrice() {
////	return extendedPrice;
////}
////
////public void setExtendedPrice(double extendedPrice) {
////	this.extendedPrice = extendedPrice;
////}
////
//////@Override
//////public String toString() {
//////	return "ListItem [listItemId=" + listItemId + ", billingStatmentId=" + billingStatmentId + ", productId="
//////			+ productId + ", quantity=" + quantity + ", extendedPrice=" + extendedPrice + "]";
//////}
//
//
//
//
