package com.rajithadev.springboot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "tbl_products")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message="Product Name is required")
	@Column(name ="name",length = 60)
    private String name;
    
	@NotNull(message="Code is required")
	@Column(name ="product_code",length = 60)
    private Integer product_code;
	
	@NotNull(message="Price is required")
	@Column(name ="price",length = 60)
    private BigDecimal price;
	
	@NotNull(message="Stock level is required")
	@Column(name ="unit",length = 60)
    private Integer unit;
	
	@NotNull(message="Status is required")
	@Column(name ="status",length = 60)
    private Integer status;

	public Product() {}
	
	
	
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

	public Integer getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Integer product_code) {
		this.product_code = product_code;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
	
	
}
