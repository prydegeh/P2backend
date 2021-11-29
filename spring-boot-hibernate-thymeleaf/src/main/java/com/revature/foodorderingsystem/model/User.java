//package com.revature.foodorderingsystem.model;
//
//import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.DiscriminatorType;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "tbl_user")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue(value="user")
//
//public class User {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	
//	@Column(name="user_id")
//	private int id;
//	
//	@Column(name="user_name")
//	private String username;
//	
//	@Column(name="email")
//	private String email;
//	
//	@Column(name="ethnicity")
//	private String ethnicity;
//	
//	@Column(name="age")
//	private int age;
//	
//	@Column(name="password")
//	private String password;
//	//private boolean isActive;
//	
//	public User() {
//		super();
//	}
//	public User(int id, String username, String email, String ethnicity, int age, String password) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.email = email;
//		this.ethnicity = ethnicity;
//		this.age = age;
//		this.password = password;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getEthnicity() {
//		return ethnicity;
//	}
//	public void setEthnicity(String ethnicity) {
//		this.ethnicity = ethnicity;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", email=" + email + ", ethnicity=" + ethnicity + ", age="
//				+ age + ", password=" + password + "]";
//	}
//
//	
//	
//}
