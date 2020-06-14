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

import com.rajithadev.springboot.model.Customer;
import com.rajithadev.springboot.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping("/add")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping("/list/{id}")
	public Optional<Customer>findById(@PathVariable Long id){
		return customerService.findById(id);
	}
	
	@RequestMapping("/list")
	public List<Customer> customerList(){
		return customerService.customerList();
		
	}
	
	@RequestMapping("/delete/{id}")	
	public String deleteCustomer(@PathVariable Long id) {
		return customerService.deleteCustomer(id);
	}
	

}
