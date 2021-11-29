package com.revature.foodorderingsystem.servicetests;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.foodorderingsystem.configuration.TestConfiguration;
import com.revature.foodorderingsystem.exception.RecordNotFoundException;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.repository.CustomerRepository;
import com.revature.foodorderingsystem.service.CustomerService;

// following example at https://www.appsdeveloperblog.com/test-restful-web-service-junit-mockito/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class CustomerServiceTest {
	
	@Mock
    private CustomerRepository repository;
	private Customer c1 = new Customer(1, "Holly", "Larsen", "hollar@email.com", "holly11", "l@r$3n"); 
    @Autowired
    @InjectMocks
    CustomerService service;
    
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    }
    
    
    @Test
    public void testCreateOrUpdateCustomer() {
    	when(repository.save(c1)).thenReturn(c1);
    	Customer result = service.createOrUpdateCustomer(c1);
    	Assert.assertNotNull(result);
        Assert.assertEquals(result.toString(), c1.toString());
    }
    
    @Test
	public void testGetAllCustomers() {
		//////////////////// Test for empty array when nothing in db //////////////////
		when((List<Customer>) repository.findAll()).thenReturn(new ArrayList<Customer>());
	    List<Customer> result = service.getAllCustomers();
	    Assert.assertNotNull(result);
	    Assert.assertTrue(result.size() == 0);
	    
	    //////////////////// Test on non-empty db //////////////////// 	
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		when(repository.findAll()).thenReturn(customers);
		result = service.getAllCustomers();
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() == customers.size());
		for (int i = 0; i < result.size(); i++) {
			Customer rc = result.get(i);
			Customer c = customers.get(i);
	        Assert.assertEquals(rc.toString(), c.toString());
		}
	}
    
    @Test
    public void testGetCustomerById() throws RecordNotFoundException {
    	//////////////////// Test for exception on empty db ////////////////////
    	try {
			service.getCustomerById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ////////////////////
        Optional<Customer> c = Optional.of(c1);
    	when(repository.findById((long) 1)).thenReturn(c);
    	Customer result;
		result = service.getCustomerById(c1.getId());
	    Assert.assertNotNull(result);
	    Assert.assertEquals(c1.toString(), result.toString());


        //////////////////// Test on non-empty db for non-existent user ////////////////////
	    try {
		    service.getCustomerById((long) 2);
	    } catch (RecordNotFoundException e) {
		    Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
	    }
    }
    
    @Test
    public void testDeleteCustomerById() throws RecordNotFoundException {
    	//////////////////// Test on empty db ////////////////////
    	try {
			service.deleteCustomerById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ///////////////////
    	List<Customer> customers = new ArrayList<Customer>();
    	customers.add(c1);
    	Optional<Customer> optC1 = Optional.of(c1);
        when(repository.findById(c1.getId())).thenReturn(optC1);
      	doAnswer(invocation -> {
      		customers.remove(c1);
      		return null;
      	}).when(repository).deleteById(c1.getId());
      	service.deleteCustomerById(c1.getId());
      	Assert.assertFalse(customers.contains(c1));
      	
    	//////////////////// Test on non-empty db for non-existent user ////////////////////
      	try {
      		service.deleteCustomerById((long) 2);
      	} catch (RecordNotFoundException e) {
      		Assert.assertEquals(e.getMessage(), "No customer record exist for given id");
      	}
    }
    
    @Test
    public void testGetCustomerByUserName() throws RecordNotFoundException {
    	//////////////////// Test for exception on empty db /////////////////////
    	try {
			service.getCustomerByUserName(c1.getUserName());
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No customer record exist for given user name");
		}
    	
    	
    	//////////////////// Test for non empty db ////////////////////
		when(repository.findByUserName(c1.getUserName())).thenReturn(c1);
		Customer result = service.getCustomerByUserName(c1.getUserName());
		Assert.assertEquals(result.toString(), c1.toString());
		
		//////////////////// Test for exception for on nonexistent username ////////////////////
    	try {
			service.getCustomerByUserName("fake username");
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No customer record exist for given user name");
		}
		
    }
}

