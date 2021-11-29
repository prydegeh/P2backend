package com.revature.foodorderingsystem.controllerstest;


import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foodorderingsystem.controller.CustomerController;
import com.revature.foodorderingsystem.exception.RecordNotFoundException;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback(false)
public class CustomerControllerTest {

	@Mock
	private CustomerService service;
	@Autowired
	private MockMvc mvc;
    @Autowired
    @InjectMocks
    private CustomerController controller;
    private JacksonTester<Customer> json; 
    private Customer c1 = new Customer(1, "Edgar", "The Old Man", "edgrrrr@email.com", "edgrrrr", "grumpledore");
    private List<Customer> mockStmts = new ArrayList<>();
    
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    	JacksonTester.initFields(this, new ObjectMapper());
    	mvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockStmts.add(c1);
    }
	
	@Test
	public void contextLoads() throws Exception {
		Assert.assertNotNull(controller);
	}
	
	@Test
	public void testGetAllCustomers() throws Exception {
        when(service.getAllCustomers()).thenReturn(mockStmts);
        
        MockHttpServletResponse response = mvc.perform(
        		get("/customers/customers")
        		.accept(MediaType.APPLICATION_JSON))
        		.andReturn().getResponse();
        
        Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
	}
	
	@Test
	public void testEditCustomerById() throws IOException, Exception {
		when(service.getCustomerById((long) 1)).thenReturn(c1);
		when(service.createOrUpdateCustomer(c1)).thenReturn(c1);
		
		MockHttpServletResponse response = mvc.perform(
				put("/customers/editCustomer/1").contentType(MediaType.APPLICATION_JSON).content(
				json.write(new Customer(1, "Edgar", "The Brave", "edgrrrr@email.com", "edgrrrr", "grumpledore")).getJson()))
				.andReturn().getResponse();
		
	    Assert.assertTrue(response.getStatus() == HttpStatus.CREATED.value()  || response.getStatus() == HttpStatus.OK.value());
	}
	
	@Test
	public void testCreateCustomer() throws IOException, Exception {
		Customer c2 = new Customer(2, "Chatita", "The Shy", "chatita@email.com", "chatita", "ihearttuna");

		doAnswer(invocation -> {
			mockStmts.add(c2);
			return c2;
		}).when(service).createOrUpdateCustomer(c2);
		
		Assert.assertTrue(mockStmts.size() == 1);
		
		MockHttpServletResponse response = mvc.perform(
				post("/customers/createCustomer").contentType(MediaType.APPLICATION_JSON).content(
				json.write(new Customer(2, "Chatita", "The Shy", "chatita@email.com", "chatita", "ihearttuna")).getJson())).andReturn().getResponse();
		
		Assert.assertTrue(response.getStatus() == HttpStatus.CREATED.value() || response.getStatus() == HttpStatus.OK.value());
		Assert.assertTrue(mockStmts.size() == 2);
		
		mockStmts.remove(c2);

	}
	
	@Test
	public void testDeleteCustomerById() throws Exception {
		Customer c2 = new Customer(2, "Chatita", "The Shy", "chatita@email.com", "chatita", "ihearttuna");
		mockStmts.add(c2);
		doAnswer(invocation -> {
			mockStmts.remove(0);
			return mockStmts;
		}).when(service).deleteCustomerById((long) 1);
		
		Assert.assertTrue(mockStmts.size() == 2);
		
		MockHttpServletResponse response = mvc.perform(
				 delete("/customers/deleteCustomer/1")).andReturn().getResponse();
		
		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
		Assert.assertTrue(mockStmts.size() == 1);
	}
	
	@Test
	public void testGetCustomerByUserName() throws Exception {
		Customer c2 = new Customer(2, "Chatita", "The Shy", "chatita@email.com", "chatita", "ihearttuna");
		mockStmts.add(c2);
		
		when(service.getCustomerByUserName(c2.getUserName())).thenReturn(c2);
		
		MockHttpServletResponse response = mvc.perform(get("/customers/getCustomerByUserName/chatita")
				.accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		
		System.out.println(response.getContentType());
		System.out.println(response.getContentAsString());
        Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
        
	}
}

