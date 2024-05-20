package com.ot.main.productmanagement.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "F_Product_Management")
@SequenceGenerator(name = "product_management_seq", sequenceName = "product_management_seq", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_management_seq")
	private Long id;
	
	@OneToOne
    @JoinColumn(name = "productcode")
	private String productCode;
		
	
	private String name;
	
	@Column (name="safetyStock")
	private Integer safetyStock;
	
	@Column (name="productStock")
	private Integer productStock;
	
	@Column(name="leadTime")
	private Integer leadTime;
	
}
