package com.rajithadev.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajithadev.springboot.model.Product;
import com.rajithadev.springboot.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/add")
	public Product addProduct(@Valid @RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	@RequestMapping("/list/{id}")
	public Optional<Product>findById(@PathVariable Long id){
		return productService.findById(id);
	}
	
	@RequestMapping("/list")
	public List<Product> productList(){
		return productService.productList();
		
	}
	
	@RequestMapping("/delete/{id}")	
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}
	
	
	
	
}
