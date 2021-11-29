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
import com.revature.foodorderingsystem.model.Product;
import com.revature.foodorderingsystem.repository.CustomerRepository;
import com.revature.foodorderingsystem.repository.ProductRepository;
import com.revature.foodorderingsystem.service.CustomerService;
import com.revature.foodorderingsystem.service.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ProductServiceTest {
	
	@Mock
    private ProductRepository repository;
	private Product p1 = new Product("Omelette", "Diner", 7.0, "http://imagehere.url"); 
    @Autowired
    @InjectMocks
    ProductService service;
    
    @Before
    public void setUp() {
    	p1.setId(1);
    	MockitoAnnotations.initMocks(this);
    }
       
    @Test
    public void testCreateOrUpdateProduct() {
    	when(repository.save(p1)).thenReturn(p1);
    	Product result = service.createOrUpdateProduct(p1);
    	Assert.assertNotNull(result);
        Assert.assertEquals(result.toString(), p1.toString());
    }
    
    @Test
	public void testGetAllProducts() {
		//////////////////// Test for empty array when nothing in db //////////////////
		when((List<Product>) repository.findAll()).thenReturn(new ArrayList<Product>());
	    List<Product> result = service.getAllProducts();
	    Assert.assertNotNull(result);
	    Assert.assertTrue(result.size() == 0);
	    
	    //////////////////// Test on non-empty db //////////////////// 	
		List<Product> products = new ArrayList<Product>();
		products.add(p1);
		when(repository.findAll()).thenReturn(products);
		result = service.getAllProducts();
		Assert.assertNotNull(result);
		Assert.assertTrue(result.size() == products.size());
		for (int i = 0; i < result.size(); i++) {
			Product rp = result.get(i);
			Product p= products.get(i);
	        Assert.assertEquals(rp.toString(), p.toString());
		}
	}
    
    @Test
    public void testGetById() throws RecordNotFoundException {
    	//////////////////// Test for exception on empty db ////////////////////
    	try {
			service.getProductById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No product record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ////////////////////
        Optional<Product> p = Optional.of(p1);
    	when(repository.findById(p1.getId())).thenReturn(p);
		Product result = service.getProductById(p1.getId());
	    Assert.assertNotNull(result);
	    Assert.assertEquals(p1.toString(), result.toString());


        //////////////////// Test on non-empty db for non-existent product ////////////////////
	    try {
		    service.getProductById((long) 2);
	    } catch (RecordNotFoundException e) {
		    Assert.assertEquals(e.getMessage(), "No product record exist for given id");
	    }
    }
    
    @Test
    public void testDeleteProductById() throws RecordNotFoundException {
    	//////////////////// Test on empty db ////////////////////
    	try {
			service.deleteProductById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No product record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ///////////////////
    	List<Product> products = new ArrayList<Product>();
    	products.add(p1);
    	Optional<Product> optP1 = Optional.of(p1);
        when(repository.findById(p1.getId())).thenReturn(optP1);
      	doAnswer(invocation -> {
      		products.remove(p1);
      		return null;
      	}).when(repository).deleteById(p1.getId());
      	service.deleteProductById(p1.getId());
      	Assert.assertFalse(products.contains(p1));
      	
    	//////////////////// Test on non-empty db for non-existent product ////////////////////
      	
      	try {
      		service.deleteProductById((long) 2);
      	} catch (RecordNotFoundException e) {
      		Assert.assertEquals(e.getMessage(), "No product record exist for given id");
      	}
    }
 
}


