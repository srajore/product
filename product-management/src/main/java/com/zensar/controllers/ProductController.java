package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	List<Product> products = new ArrayList<Product>();

	public ProductController() {
		products.add(new Product(1, "Laptop", 50000));
		products.add(new Product(2, "Mouse", 500));
		products.add(new Product(3, "HDD", 4500));
	}

	// http://localhost:8080/

	// @RequestMapping("/products/{myName}")
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	// http://localhost:8080/products
	@RequestMapping("/")
	public List<Product> getAllProducts() {
		return products;
	}

	// @RequestMapping(value ="/products/{productId}",method=RequestMethod.DELETE)
	@DeleteMapping("/{productId}")
	public Product deleteProduct(@PathVariable("productId") int productId) {

		for (int i = 0; i < products.size(); i++) {

			Product product = products.get(i);

			if (product.getProductId() == productId) {
				products.remove(product);
			}
		}
		return null;
	}

	@PostMapping("/")
	public Boolean insertProduct(@RequestBody Product product) {
		return products.add(product);

	}

	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {

		Product availableProduct = getProduct(productId);

		if (availableProduct != null) {
			availableProduct.setProductId(product.getProductId());
			availableProduct.setProductName(product.getProductName());
			availableProduct.setProductCost(product.getProductCost());
		}

		return availableProduct;
	}

}
