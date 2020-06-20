package com.rajithadev.springboot.service;

import java.util.List;
import java.util.Optional;

import com.rajithadev.springboot.model.Product;

public interface ProductService {
	List<Product> productList();

	Optional<Product> findById(Long id);

	Product addProduct(Product product);

	String deleteProduct(Long id);

	Product fetchProductName(String name);



}
