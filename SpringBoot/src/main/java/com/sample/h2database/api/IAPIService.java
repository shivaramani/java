package com.sample.h2database.api;

import java.util.List;

import com.sample.h2database.product.Product;

public interface IAPIService {
	public List<Product> findAll();
	
	public Boolean addProduct(String name, String description);
}
