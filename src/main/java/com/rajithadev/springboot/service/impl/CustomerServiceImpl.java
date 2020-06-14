package com.rajithadev.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajithadev.springboot.model.Customer;
import com.rajithadev.springboot.repository.CustomerRepository;
import com.rajithadev.springboot.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public  CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	
	@Override
	public List<Customer> customerList() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public String deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		return "{'Message' : 'Customer Deleted Successfully!'}";
	}
	
}
