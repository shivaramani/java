package com.sample.h2database.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.h2database.product.Product;
import com.sample.h2database.product.ProductRepository;

@Service
public class APIService implements IAPIService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public Boolean addProduct(String name, String description) {
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		productRepository.save(product);
		return true;
	}
}
