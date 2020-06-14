package com.rajithadev.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rajithadev.springboot.model.OrderDetail;

public  interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{


	
	
}

