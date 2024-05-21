package com.ot.main.delivery.data.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;


import org.springframework.validation.annotation.Validated;
import lombok.Data;

@Validated
@Entity
@Table(name= "F_Delivery")
@Data
public class Delivery {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_seq")
   private Long id; 

   @Column(nullable = false)
   @Digits(integer = 10, fraction = 0)
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
   
   @Column(nullable = false, name="productcode")
   private String productCode;
   
    
   
}