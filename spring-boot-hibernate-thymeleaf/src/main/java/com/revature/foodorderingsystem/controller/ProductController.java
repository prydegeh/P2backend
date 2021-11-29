package com.revature.foodorderingsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.foodorderingsystem.exception.RecordNotFoundException;
import com.revature.foodorderingsystem.model.Customer;
import com.revature.foodorderingsystem.model.Product;
import com.revature.foodorderingsystem.service.CustomerService;
import com.revature.foodorderingsystem.service.ProductService;

@CrossOrigin(origins="*")
@RestController
@Controller
@RequestMapping("/products")
public class ProductController 
{
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() 
	{
		return service.getAllProducts();

	}
	
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable long id) throws RecordNotFoundException {
		return service.getProductById(id);
	}
			
	@PutMapping(path = {"/editProduct/{id}"})
	public ResponseEntity<Product> editProductById(@PathVariable(value = "id") Long id, @Valid @RequestBody Product productDetails) 
							throws RecordNotFoundException 
	{
		log.info("In editProductById()");
		
		Product product = service.getProductById(id);
		
		product.setProductName(productDetails.getProductName());
		product.setRestaurantName(productDetails.getRestaurantName());
		product.setUnitPrice(productDetails.getUnitPrice());
		product.setImg_url(productDetails.getImg_url());
		
		final Product updateProduct = service.createOrUpdateProduct(product);
		return ResponseEntity.ok(updateProduct);
	}
	
	@DeleteMapping(path = "deleteProduct/{id}")
	public Map<String, Boolean> deleteProductById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		log.info("In deleteProductById()");
		service.deleteProductById(id);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping(path = "/createProduct")
	public Product createProduct(@Valid @RequestBody Product product) 
	{
		log.info("In createProduct()");
		return service.createOrUpdateProduct(product);
	}
}
