package com.rajithadev.springboot.service;

import java.util.List;
import java.util.Optional;

import com.rajithadev.springboot.model.Customer;

public interface CustomerService {
	
	List<Customer> customerList();
	
	Optional<Customer> findById(Long id);
	
	Customer addCustomer(Customer customer);
	
	String deleteCustomer (Long id);
}
