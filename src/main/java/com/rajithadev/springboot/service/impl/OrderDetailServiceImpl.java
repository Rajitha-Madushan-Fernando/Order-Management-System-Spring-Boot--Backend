package com.rajithadev.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rajithadev.springboot.model.OrderDetail;
import com.rajithadev.springboot.repository.OrderDetailRepository;
import com.rajithadev.springboot.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	private OrderDetailRepository orderDetailRepository;
	
	public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
		this.orderDetailRepository = orderDetailRepository;
	}
	
	@Override
	public List<OrderDetail> orderDetailList() {
		return orderDetailRepository.findAll();
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return orderDetailRepository.findById(id);
	}

	@Override
	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		return orderDetailRepository.save(orderDetail);
	}

	@Override
	public String deleteOrderDetail(Long id) {
		orderDetailRepository.deleteById(id);
		return "{'Message' : 'Unique Order deleted Successfully'}";
	}

	
}
