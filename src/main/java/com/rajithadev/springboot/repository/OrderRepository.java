package com.rajithadev.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rajithadev.springboot.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
