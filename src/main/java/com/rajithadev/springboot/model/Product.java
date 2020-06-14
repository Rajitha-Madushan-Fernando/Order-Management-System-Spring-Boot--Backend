package com.rajithadev.springboot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name ="name",length = 60)
    private String name;
    
	@Column(name ="product_code",length = 60)
    private String product_code;

	@Column(name ="price",length = 60)
    private BigDecimal price;
	
	@Column(name ="unit",length = 60)
    private String unit;
	
	@Column(name ="status",length = 60)
    private Integer status;

	

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", product_code=" + product_code + ", price=" + price
				+ ", unit=" + unit + ", status=" + status + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
}
