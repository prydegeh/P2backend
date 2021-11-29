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
import com.revature.foodorderingsystem.model.BillingStatement;
import com.revature.foodorderingsystem.model.Product;
import com.revature.foodorderingsystem.repository.BillingStatementRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@DataJpaTest
@Rollback(false)
public class BillingStatementRepositoryTest {
	
	@Autowired
	private BillingStatementRepository repository;
	private BillingStatement billStmt = new BillingStatement(1000, 4230);
	private Product product = new Product();
	
	@Before
	public void setUpBeforeClass() {
        billStmt.setProduct(product);
		repository.save(billStmt);
	}

	@Test
	public void createBillingStatement() {
		BillingStatement b = new BillingStatement(2, 10.50);
		b.setProduct(new Product());
		BillingStatement result = repository.save(b);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getId() != 0);
		Assert.assertTrue(result.getQuantity() == b.getQuantity());
		Assert.assertTrue(result.getExtendedPrice() == b.getExtendedPrice());
		repository.delete(result);
	}
	
	@Test
	public void getBillingStatementById() {
		BillingStatement result = repository.findById(billStmt.getId()).get();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.toString(), billStmt.toString());
	}
	
	@Test
	public void getAllBillingStatements() {
		List<BillingStatement> result = (List<BillingStatement>) repository.findAll();
		Assert.assertFalse(0 == result.size());
	}
	
	@Test
	public void updateBillingStatement() {
		billStmt.setQuantity(3);;
		BillingStatement result = repository.save(billStmt);
		Assert.assertNotNull(result);
		Assert.assertEquals(result.toString(), billStmt.toString());
	}
	
	@Test
	public void deleteBillingStatement() {
		BillingStatement b = new BillingStatement(2, 10.50);
		b.setProduct(new Product());
		BillingStatement result = repository.save(b);
		List<BillingStatement> allBillingStatements = (List<BillingStatement>) repository.findAll();
		int sizeBeforeDelete = allBillingStatements.size();
		repository.delete(result);
		allBillingStatements = (List<BillingStatement>) repository.findAll();
		int sizeAfterDelete = allBillingStatements.size();
		Assert.assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
	}
}
