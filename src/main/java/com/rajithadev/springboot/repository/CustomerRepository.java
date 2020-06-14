package com.rajithadev.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajithadev.springboot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
