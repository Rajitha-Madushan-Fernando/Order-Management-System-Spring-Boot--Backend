package com.rajithadev.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajithadev.springboot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}