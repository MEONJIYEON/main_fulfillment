package com.ot.main.product.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="F_Product")
public class Product {
	@Id
	@Column(name="productCode")
	private String productCode;
	
	@Column (nullable= false , name="safetyStock")
	private Integer safetyStock;
	
	private String name;
	
	@Column (nullable= false , name="productStock")
	private Integer productStock;
	
	@Column(name="leadTime")
	private LocalDateTime leadTime;
	
	@Column(nullable = false)
	private LocalDateTime create_at;
	
	private LocalDateTime updated_at;
	
	@PrePersist
    protected void onCreate() {
        create_at = LocalDateTime.now();
        updated_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }
}


