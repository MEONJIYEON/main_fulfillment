package com.ot.main.productmanagement.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "F_Product_Management")
@Data
public class ProductManagement {

	@Id
	private Integer stockNo;
	
	@Column(nullable = false)
	private String productCode;
	private int productStock;
	private int leadTime;
}
