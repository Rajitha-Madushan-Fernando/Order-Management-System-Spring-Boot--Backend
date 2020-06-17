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

import com.rajithadev.springboot.model.OrderDetail;

import com.rajithadev.springboot.service.OrderDetailService;

@RestController
@RequestMapping("/order-detail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderDetailController {
	private OrderDetailService orderDetailService;

	@Autowired
	public OrderDetailController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	@RequestMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public OrderDetail addOrderDetail(@Valid @RequestBody OrderDetail orderDetail) {
		return orderDetailService.addOrderDetail(orderDetail);
	}
	
	@RequestMapping("/list/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('pm')")
	public Optional<OrderDetail> findById(@PathVariable Long id) {
		return orderDetailService.findById(id);
	}
	
	
	@RequestMapping("/list")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('pm')")
	public List<OrderDetail> orderDetailList(){
		return orderDetailService.orderDetailList();
	}
	
	@RequestMapping("/delete/{id}")	
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteOrderDetail(@PathVariable Long id) {
		return orderDetailService.deleteOrderDetail(id);
	}
	
}
