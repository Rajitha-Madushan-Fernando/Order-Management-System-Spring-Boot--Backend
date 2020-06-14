package com.rajithadev.springboot.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Customer customer;

	@Column(name = "order_unique_id", length = 60)
	private String order_unique_id;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "status", length = 10)
	private Integer status;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;

	@OneToMany(targetEntity = OrderDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderDetail> orderDetails;


	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", order_unique_id=" + order_unique_id + ", remarks="
				+ remarks + ", status=" + status + ", orderDate=" + orderDate + ", orderDetails=" + orderDetails + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getOrder_unique_id() {
		return order_unique_id;
	}

	public void setOrder_unique_id(String order_unique_id) {
		this.order_unique_id = order_unique_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
