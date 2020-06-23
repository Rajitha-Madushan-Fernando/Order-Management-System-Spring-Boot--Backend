package com.rajithadev.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Product addProduct(@Valid @RequestBody Product product) throws Exception {
		
		String tempProductName = product.getName();
		System.out.println(tempProductName);
		if(tempProductName != null) {
			Product productObj = productService.fetchProductName(tempProductName);
			if(productObj != null) {
				throw new Exception("Product with this " +tempProductName+" is already exist");
			}
		}
		
		Product productObj = null;
		productObj= productService.addProduct(product);
		return productObj;
	}
	
	
	@RequestMapping("/list/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public Optional<Product>findById(@PathVariable Long id){
		return productService.findById(id);
	}
	
	@RequestMapping("/list")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('PM')")
	public List<Product> productList(){
		return productService.productList();
		
	}
	
	@RequestMapping("/delete/{id}")	
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}
	
	
	
	
}
