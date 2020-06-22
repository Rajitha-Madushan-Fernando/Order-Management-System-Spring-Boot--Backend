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
import com.rajithadev.springboot.service.ProductService;

@RestController
@RequestMapping("/order-detail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderDetailController {
	private OrderDetailService orderDetailService;
	
	
	
	@Autowired
	private ProductService productService;

	@Autowired
	public OrderDetailController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	
	
	@RequestMapping("/add")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public OrderDetail addOrderDetail(@Valid @RequestBody OrderDetail orderDetail) throws Exception {
		
		Integer requestQuantity = orderDetail.getQuantity();
		//System.out.println(requestQuantity);
		
		Long id = orderDetail.getProduct().getId();
		//System.out.println(id);
		
		Integer currentStock = productService.findById(orderDetail.getProduct().getId()).get().getUnit();
		//System.out.println(stock);
		if(currentStock == 0) {
			throw new Exception("Empty stock level!");
		}
		else if(requestQuantity > currentStock) {
			throw new Exception("This Product curernt stock level is "+ currentStock +".");
		}else {
			
			Integer updateStocklevel = currentStock - requestQuantity;
			productService.findById(id).get().setUnit(updateStocklevel);
			return orderDetailService.addOrderDetail(orderDetail);
			
		}
		
		
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
