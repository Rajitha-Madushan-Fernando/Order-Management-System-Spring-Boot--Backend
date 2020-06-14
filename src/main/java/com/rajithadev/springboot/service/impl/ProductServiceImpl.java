package com.rajithadev.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajithadev.springboot.model.Product;
import com.rajithadev.springboot.repository.ProductRepository;
import com.rajithadev.springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	@Autowired
	public  ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository= productRepository;
	}
	
	@Override
	public List<Product> productList() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		 return "{'Message' : 'Product deleted Successfully'}";
	}
	
}
