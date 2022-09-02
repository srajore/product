package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Product;
import com.zensar.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProduct(int productId) {
		return productRepository.findById(productId).get();
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(int productId) {

		productRepository.deleteById(productId);
	}

	@Override
	public Product insertProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(int productId, Product product) {

		Product availableProduct = getProduct(productId);

		if (availableProduct != null) {
			availableProduct.setProductId(product.getProductId());
			availableProduct.setProductName(product.getProductName());
			availableProduct.setProductCost(product.getProductCost());
		}

		return productRepository.save(availableProduct);

	}

}
