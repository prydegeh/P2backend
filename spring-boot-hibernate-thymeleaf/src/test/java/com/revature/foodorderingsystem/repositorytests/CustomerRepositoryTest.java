package com.revature.foodorderingsystem.repositorytests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.foodorderingsystem.configuration.TestConfiguration;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@DataJpaTest
@Rollback(false)
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository repository;
	private Customer customer = new Customer(1, "Holly", "Larsen", "hollar@email.com", "holly11", "l@r$3n");
	
	@Before
	public void setUp() {
		repository.save(customer);
	}
	
	@Test
	public void createCustomer() {
		Customer c = new Customer(2, "unit", "test", "unittest@email.com", "blah", "halb");
		Customer result = repository.save(c);
		Assert.assertNotNull(result);
		Assert.assertEquals(c.getFirstName(), result.getFirstName());
		Assert.assertEquals(c.getLastName(), result.getLastName());
		Assert.assertEquals(c.getEmail(), result.getEmail());
		Assert.assertEquals(c.getUserName(), result.getUserName());
		Assert.assertEquals(c.getPassword(), result.getPassword());
		repository.delete(result);
	}
	
	@Test
	public void getCustomerById() {
		Customer result = repository.findById(customer.getId()).get();
		Assert.assertEquals(customer.toString(), result.toString());
	}
	
	@Test
	public void getAllCustomers() {
		List<Customer> result = (List<Customer>) repository.findAll();
		Assert.assertFalse(0 == result.size());
	}
	
	@Test
	public void updateCustomer() {
		customer.setEmail("MyNewEmail@email.com");
		Customer result = repository.save(customer);
		Assert.assertEquals(customer.toString(), result.toString());
	}
	
	@Test
	public void deleteEmployee() {
		Customer c = new Customer(2, "unit", "test", "unittest@email.com", "blah", "halb");
		Customer result = repository.save(c);
		List<Customer> allCustomers = (List<Customer>) repository.findAll();
		int sizeBeforeDelete = allCustomers.size();
		repository.delete(result);
		allCustomers = (List<Customer>) repository.findAll();
		int sizeAfterDelete = allCustomers.size();
		Assert.assertTrue(sizeBeforeDelete - 1 == sizeAfterDelete);
	}
	
	@Test
	public void getCustomerByUsername () {
		Customer result = repository.findByUserName(customer.getUserName());
		Assert.assertEquals(customer.toString(), result.toString());
	}
}


