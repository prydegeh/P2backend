package com.revature.foodorderingsystem.servicetests;

import static org.mockito.ArgumentMatchers.any;
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
import com.revature.foodorderingsystem.model.BillingStatement;
import com.revature.foodorderingsystem.repository.BillingStatementRepository;
import com.revature.foodorderingsystem.service.BillingStatementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class BillingStatementServiceTest {

	@Mock
    private BillingStatementRepository repository;
	private BillingStatement b1 = new BillingStatement(3, 12.75);
    @Autowired
    @InjectMocks
    BillingStatementService service;
    
    @Before
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    	b1.setId((long) 1);
    }
    
    @Test
    public void testCreateOrUpdateBillingStatement() {
    	// mocking billing statement repository method
    	when(repository.save(any(BillingStatement.class))).thenReturn(b1);
    	BillingStatement result = service.createOrUpdateBillingStatement(b1);
    	Assert.assertNotNull(result);
        Assert.assertEquals(result.toString(), b1.toString());
    }
    
    @Test
    public void testGetAllBillingStatements() {
    	//////////////////// Test for empty array when nothing in db //////////////////
    	when((List<BillingStatement>) repository.findAll()).thenReturn(new ArrayList<BillingStatement>());
        List<BillingStatement> result = service.getAllBillingStatements();
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() == 0);
        
        //////////////////// Test on non-empty db //////////////////// 	
    	List<BillingStatement> billStmts = new ArrayList<BillingStatement>();
    	when(repository.findAll()).thenReturn(billStmts);
    	result = service.getAllBillingStatements();
    	Assert.assertNotNull(result);
    	Assert.assertTrue(result.size() == billStmts.size());
    	for (int i = 0; i < result.size(); i++) {
    		BillingStatement rb = result.get(i);
    		BillingStatement b = billStmts.get(i);
        	Assert.assertNotNull(result);
            Assert.assertEquals(rb.toString(), b.toString());
    	}
    }
    
    @Test
    public void testGetBillingStatementsById() throws RecordNotFoundException {
    	//////////////////// Test for exception on empty db ////////////////////
    	try {
			service.getBillingStatementById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ////////////////////
        Optional<BillingStatement> optB1 = Optional.of(b1);
    	when(repository.findById(b1.getId())).thenReturn(optB1);
		BillingStatement result = service.getBillingStatementById(b1.getId());
	    Assert.assertNotNull(result);
        Assert.assertEquals(result.toString(), b1.toString());

    
        //////////////////// Test on non-empty db for non-existent billing statement ////////////////////
	    try {
		    service.getBillingStatementById((long) 3);
	    } catch (RecordNotFoundException e) {
		    Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
	    }
    }
    
    @Test
    public void testDeleteBillingStatementById() throws RecordNotFoundException {
    	//////////////////// Test on empty db ////////////////////
    	try {
			service.deleteBillingStatementById((long) 1);
		} catch (RecordNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
		}
    	
    	//////////////////// Test on non-empty db ///////////////////
    	// mocking billing statement methods
    	List<BillingStatement> billStmts = new ArrayList<BillingStatement>();
    	billStmts.add(b1);
        Optional<BillingStatement> optB1 = Optional.of(b1);
    	when(repository.findById(b1.getId())).thenReturn(optB1);
      	doAnswer(invocation -> {
      		billStmts.remove(b1);
      		return null;
      	}).when(repository).deleteById(b1.getId());
      	service.deleteBillingStatementById(b1.getId());
        Assert.assertFalse(billStmts.contains(b1));
        
    	//////////////////// Test on non-empty db for non-existent billing statement ////////////////////
      	try {
      		service.deleteBillingStatementById((long) 1);
      	} catch (RecordNotFoundException e) {
      		Assert.assertEquals(e.getMessage(), "No billing statement record exist for given id");
      	}
    }
}
