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

import com.rajithadev.springboot.model.Order;
import com.rajithadev.springboot.service.OrderService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {
	private OrderService orderService;
	
	@Autowired
	public OrderController( OrderService orderService ) {
		this.orderService = orderService;
	}
	
	@RequestMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Order addOrder(@Valid @RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	
	
	@RequestMapping("/list/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('pm')")
	public Optional<Order> findById(@PathVariable Long id) {
		return orderService.findById(id);
	}
	
	
	@RequestMapping("/list")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('pm')")
	public List<Order> orderList(){
		return orderService.orderList();
	}
	
	@RequestMapping("/delete/{id}")	
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteUser(@PathVariable Long id) {
		return orderService.deleteOrder(id)	;
	}
	
	
}
