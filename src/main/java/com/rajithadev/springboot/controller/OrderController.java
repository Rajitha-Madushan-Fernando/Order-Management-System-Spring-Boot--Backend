package com.rajithadev.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajithadev.springboot.model.Order;
import com.rajithadev.springboot.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public OrderController( OrderService orderService ) {
		this.orderService = orderService;
	}
	
	@RequestMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	
	@RequestMapping("/list/{id}")
	public Optional<Order> findById(@PathVariable Long id) {
		return orderService.findById(id);
	}
	
	
	@RequestMapping("/list")
	public List<Order> orderList(){
		return orderService.orderList();
	}
	
	@RequestMapping("/delete/{id}")	
	public String deleteUser(@PathVariable Long id) {
		return orderService.deleteOrder(id)	;
	}
	
	
}
