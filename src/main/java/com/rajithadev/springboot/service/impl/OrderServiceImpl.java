package com.rajithadev.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajithadev.springboot.model.Order;
import com.rajithadev.springboot.repository.OrderRepository;
import com.rajithadev.springboot.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> orderList() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public String deleteOrder(Long id) {
		orderRepository.deleteById(id);
		return "{'Message' : 'Order deleted Successfully'}";
	}

}
