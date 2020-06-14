package com.rajithadev.springboot.service;

import java.util.List;
import java.util.Optional;

import com.rajithadev.springboot.model.Order;

public interface OrderService {
	
	List<Order> orderList();
	
	Optional<Order> findById(Long id);
	
	Order addOrder(Order order);
	
	String deleteOrder (Long id);
}
