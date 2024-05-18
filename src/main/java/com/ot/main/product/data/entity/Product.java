package com.ot.main.product.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="F_Product")
public class Product {
	@Id
	private Long id;
}


