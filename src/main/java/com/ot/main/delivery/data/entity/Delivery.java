package com.ot.main.delivery.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import lombok.Data;

@Validated
@Entity
@Table(name= "F_Delivery")
@Data
public class Delivery {

	@Id
	@Size(max = 10, min = 10)
	private Integer trackingNumber;
	
	@Column(nullable = false, name="userName")
	private String userName;
	
	@Column(nullable = false)
	private String hp1;
	
	@Column(nullable = false)
	private String hp2;
	
	@Column(nullable = false)
	private String hp3;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String zipcode;
	
	@Column(nullable = false, name="productName")
	private String productName;
	
	@Column(nullable = false, name="stockCount")
	private Integer stockCount;
	
	@Column(nullable = false, name="statusDelivery")
	private String statusDelivery;
    
	
}