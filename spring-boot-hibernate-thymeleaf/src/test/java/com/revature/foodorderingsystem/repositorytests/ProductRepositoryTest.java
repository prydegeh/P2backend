package com.revature.foodorderingsystem.repositorytests;

import java.util.ArrayList;
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
import com.revature.foodorderingsystem.model.BillingStatement;
import com.revature.foodorderingsystem.model.Product;
import com.revature.foodorderingsystem.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@DataJpaTest
@Rollback(false)
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository repository;
	private Product product = new Product("Huevos Rancheros", "Torreros", 8.50, "http://rancheggsphoto.com");
	private List<BillingStatement> stmt = new ArrayList<BillingStatement>();
	
	@Before
	public void setUp() {
		product.setBillingStatements(stmt);
		repository.save(product);
	}
	
	@Test
	public void createProduct() {
		Product p = new Product("Baingan Bharta", "Kabab & Curry" , 10.75 , "http://eggplantdishphoto.com");
		p.setBillingStatements(new ArrayList<BillingStatement>());
		Product result = repository.save(p);
		Assert.assertNotNull(result);
        Assert.assertTrue(result.getId() != 0);
        Assert.assertEquals(result.getProductName(), p.getProductName());
        Assert.assertEquals(result.getRestaurantName(), p.getRestaurantName());
        Assert.assertTrue(result.getUnitPrice() == p.getUnitPrice());
        Assert.assertEquals(result.getImg_url(), p.getImg_url());
		repository.delete(result);
	}
	
	@Test
	public void getProductById() {
		Product result = repository.findById(product.getId()).get();
		Assert.assertEquals(product.toString(), result.toString());
	}
	
	@Test
	public void getAllProducts() {
		List<Product> result = (List<Product>) repository.findAll();
		Assert.assertFalse(0 == result.size());
	}
	
	@Test
	public void updateProduct() {
		product.setImg_url("http://neweggphoto.com");
		Product result = repository.save(product);
		Assert.assertEquals(product.toString(), result.toString());
	}
	
	@Test
	public void deleteProduct() {
		Product p = new Product("Khoresh Bademjan", "Parvenah", 11.00, "http://persian/eggplanstew.com");
		Product result = repository.save(p);
		List<Product> allProducts = (List<Product>) repository.findAll();
		int sizeBeforeDelete = allProducts.size();
		repository.delete(result);
		allProducts = (List<Product>) repository.findAll();
		int sizeAfterDelete = allProducts.size();
		Assert.assertTrue(sizeBeforeDelete - 1 == sizeAfterDelete);
	}
}


