package com.rajithadev.springboot.service;

import java.util.List;
import java.util.Optional;

import com.rajithadev.springboot.model.OrderDetail;

public interface OrderDetailService {
	List<OrderDetail> orderDetailList();
	
	Optional<OrderDetail> findById(Long id);
	
	OrderDetail addOrderDetail(OrderDetail orderDetail);
	
	String deleteOrderDetail (Long id);
	
	
}
