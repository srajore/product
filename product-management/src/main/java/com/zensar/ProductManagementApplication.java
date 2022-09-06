package com.zensar;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zensar.entity.Product;
import com.zensar.entity.Vendor;
import com.zensar.repositories.ProductRepository;

@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		
	//	ConfigurableApplicationContext run = SpringApplication.run(ProductManagementApplication.class, args);
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ProductManagementApplication.class, args);
	
		ProductRepository productRepository=(ProductRepository)configurableApplicationContext.getBean("productRepository");
	
		Product product=new Product();
		product.setProductName("test");
		product.setProductCost(1234);
		
		Vendor vendor1 =new Vendor();
		vendor1.setVendorName("iiht");
		vendor1.setProduct(product);
		
		Vendor vendor2 =new Vendor();
		vendor2.setVendorName("seeed");
		vendor2.setProduct(product);
		
		product.setVendors(Arrays.asList(vendor1,vendor2));
		
		productRepository.save(product);
		
		
	
	}

}
