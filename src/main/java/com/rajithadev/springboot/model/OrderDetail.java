package com.rajithadev.springboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "tbl_order_details")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Product product;
	
	@Column(name = "order_id", length = 60)
	private Integer order_id;
	
	@Column(name = "quantity", length = 60)
	private Integer quantity;
	
	
	

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", product=" + product + ", order_id=" + order_id + ", quantity=" + quantity
				+ "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getOrder_id() {
		return order_id;
	}


	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	

}
