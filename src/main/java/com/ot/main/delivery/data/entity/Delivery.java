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
	
	@Column(nullable = false)
	private String userName;
	private int hp1;
	private int hp2;
	private int hp3;
    private String address;
    private String zipcode;
    private String productName;
    private int stockCount;
    private String statusDelivery;
    
	
}