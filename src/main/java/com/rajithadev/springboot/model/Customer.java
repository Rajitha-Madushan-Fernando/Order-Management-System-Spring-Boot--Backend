package com.rajithadev.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Name is required!")
	@Column(name ="customer_name",length = 60)
    private String customer_name;
    
	@NotNull(message="Address is required")
	@Column(name ="address",length = 60)
    private String address;
	
	@NotNull(message="Customer Unique ID is required")
	@Column(name ="cus_unique_id",length = 60)
    private Integer cus_unique_id;

	@NotNull(message="Contact Number is required")
	@Column(name ="contact_number",length = 60)
    private Integer contact_number;
	
	@NotNull(message="Email is required")
	@Column(name ="email",length = 60)
    private String email;

	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_name=" + customer_name + ", address=" + address + ", cus_unique_id="
				+ cus_unique_id + ", contact_number=" + contact_number + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContact_number() {
		return contact_number;
	}

	public void setContact_number(Integer contact_number) {
		this.contact_number = contact_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCus_unique_id() {
		return cus_unique_id;
	}

	public void setCus_unique_id(Integer cus_unique_id) {
		this.cus_unique_id = cus_unique_id;
	}
	
	
	
}
