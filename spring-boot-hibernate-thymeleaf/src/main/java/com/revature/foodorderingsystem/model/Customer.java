package com.revature.foodorderingsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email")
    private String email;
    
    @Column(name="user_name")
	private String userName;
	
    @Column(name="password")
    private String password;

	public Customer() {
		super();
	}

	public Customer(long id, String firstName, String lastName, String email, String userName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	
	/**Don't need to manually create getters and setters. Lombok's @Data annotation on the class does this for us. */
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
}






//@Entity
//@Table(name="customer")
//public class Customer implements Serializable{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
////    
//    @Column(name="first_name")
//    private String firstName;
//    
//    @Column(name="last_name")
//    private String lastName;
//    
//    @Column(name="email")
//    private String email;
//    
////	@OneToMany(cascade = CascadeType.ALL)
////	@JoinColumn(name="customer_id")
////	//@JoinColumn(mappedBy="customer_id")
////	private List<BillingStatement> billingstatements;
//	
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
//	private Set<BillingStatement> billingStatements = new HashSet<BillingStatement>();
//	
//	
//
//	public Customer() {
//		super();
//	}
//
//	public Customer(String firstName, String lastName, String email) {
//		super();
//		//this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		//this.billingstatements = billingstatements;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Set<BillingStatement> getBillingStatements() {
//		return billingStatements;
//	}
//
//	public void setBillingStatements(Set<BillingStatement> billingStatements) {
//		this.billingStatements = billingStatements;
//	}
//
//	
//
//	
//    
//}
//


