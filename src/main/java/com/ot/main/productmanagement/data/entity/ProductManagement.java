package com.ot.main.productmanagement.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ot.main.product.data.entity.Product;

import lombok.Data;

@Entity
@Table(name = "F_Product_Management")
@SequenceGenerator(name = "product_management_seq", sequenceName = "product_management_seq", allocationSize = 1)
@Data
public class ProductManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_management_seq")
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "productCode")
	private Product Product;
	
}
