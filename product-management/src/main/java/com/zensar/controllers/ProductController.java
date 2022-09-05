package com.zensar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Product;
import com.zensar.exceptions.InvalidProductIdException;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// http://localhost:8080/

	// @RequestMapping("/products/{myName}")
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) throws InvalidProductIdException {
		if(productId<0) {
			throw new InvalidProductIdException("Sorry, Invalid Product Id");
		}
		return productService.getProduct(productId);

	}

	// http://localhost:8080/products
	@RequestMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	// @RequestMapping(value ="/products/{productId}",method=RequestMethod.DELETE)
	@DeleteMapping("/{productId}")
	public void deleteProduct(@RequestHeader("auth-token") String token, @PathVariable("productId") int productId) {

		productService.deleteProduct(productId);
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		
		return new ResponseEntity<Product>(productService.insertProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}

}
