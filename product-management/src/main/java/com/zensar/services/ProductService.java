package com.zensar.services;

import java.util.List;

import com.zensar.entity.Product;

public interface ProductService {
	
	public Product getProduct(int productId);
	
	public List<Product> getAllProducts();
	
	public void deleteProduct(int productId);
	
	public Product insertProduct(Product product);
	
	public Product updateProduct( int productId,  Product product) ;

}
